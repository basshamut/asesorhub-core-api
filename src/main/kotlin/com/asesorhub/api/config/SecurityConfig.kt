package com.asesorhub.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(
                    "/unauthenticated",
                    "/oauth2/**",
                    "/login/**",
                    "/swagger*/**",
                    "/v3/api-docs/**",
                    "/console/**",
                    "/swagger*/**",
                    "/v3/api-docs/**",
                    "/error"
                ).permitAll()
                it.anyRequest().authenticated()
            }
            .addFilterAfter(JwtAuth0SecurityFilter(), BasicAuthenticationFilter::class.java)
            .addFilterAfter(JwtAuth0SecurityFilter(), BasicAuthenticationFilter::class.java)

        return http.build()
    }
}
