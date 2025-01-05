package com.asesorhub.api.config

import com.auth0.jwk.Jwk
import com.auth0.jwk.JwkProvider
import com.auth0.jwk.JwkProviderBuilder
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.interfaces.DecodedJWT
import jakarta.servlet.*
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import java.io.IOException
import java.net.URL
import java.security.interfaces.RSAPublicKey

class JwtAuth0SecurityFilter : Filter {
    var logger: Logger = LoggerFactory.getLogger(javaClass)
    private var jwkProvider: JwkProvider =
        JwkProviderBuilder(URL("https://dev-7z72cbvm1xnup3l1.us.auth0.com/.well-known/jwks.json")).build()

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        try {
            val authorizationHeader = (request as HttpServletRequest).getHeader("Authorization")
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                chain.doFilter(request, response)
                return
            }

            val token = authorizationHeader.substring(7)
            val decodedJWT: DecodedJWT = JWT.decode(token)
            val jwk: Jwk = jwkProvider.get(decodedJWT.keyId)
            val algorithm: Algorithm = Algorithm.RSA256(jwk.publicKey as RSAPublicKey, null)

            val verifier: JWTVerifier = JWT.require(algorithm)
                .withIssuer("https://dev-7z72cbvm1xnup3l1.us.auth0.com/")
                .build()
            verifier.verify(decodedJWT)

            SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken(
                    decodedJWT.subject, null,
                    listOf(SimpleGrantedAuthority("SIMPLE_AUTHORITY"))
                )
        } catch (jwtVerificationException: JWTVerificationException) {
            logger.error("Verification Exception", jwtVerificationException)
        } catch (e: Exception) {
            logger.error("Exception", e)
        }
        chain.doFilter(request, response)
        SecurityContextHolder.clearContext()
    }
}
