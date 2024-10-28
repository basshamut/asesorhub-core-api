package com.asesorhub.api.controller.advisor.dto.response

import com.fasterxml.jackson.annotation.JsonInclude
import java.sql.Timestamp

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class AdvisorResponseJson (
    var id: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var phone: String = "",
    var creationDate: Timestamp? = null
)