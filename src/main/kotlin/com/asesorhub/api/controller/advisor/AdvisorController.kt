package com.asesorhub.api.controller.advisor

import com.asesorhub.api.controller.advisor.dto.request.AdvisorRequestJson
import com.asesorhub.api.controller.advisor.dto.response.AdvisorResponseJson
import com.asesorhub.api.service.advisor.AdvisorService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/api/v1"])
class AdvisorController {

    @Autowired
    private lateinit var recruiterService: AdvisorService

    @GetMapping("/recruiters")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun retrieveAll(): ResponseEntity<List<AdvisorResponseJson>> {
        val dtoList: List<AdvisorResponseJson> = recruiterService.findAll()
        return ResponseEntity.ok().body(dtoList)
    }

    @PostMapping("/recruiters")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody recruiter: AdvisorRequestJson): ResponseEntity<AdvisorResponseJson> {
        val dto = recruiterService.create(recruiter)
        return ResponseEntity.ok().body(dto)
    }
}