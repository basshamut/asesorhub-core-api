package com.asesorhub.api.controller.advisor.dto.request

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class AdvisorRequestJson (
    var firstName: String = "",
    var lastName: String = "",
    @field:Email(message = "Email should be valid")
    var email: String = "",
    @field:Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Mobile number is invalid")
    var phone: String = "",
)