package com.asesorhub.api.service.advisor

import com.asesorhub.api.controller.advisor.dto.request.AdvisorRequestJson
import com.asesorhub.api.controller.advisor.dto.response.AdvisorResponseJson

interface AdvisorService {
    fun findAll(): List<AdvisorResponseJson>
    fun create(recruiter: AdvisorRequestJson): AdvisorResponseJson
}