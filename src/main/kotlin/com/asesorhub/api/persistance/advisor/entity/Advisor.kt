package com.asesorhub.api.persistance.advisor.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document(collection = "advisors")
data class Advisor(
    @Id
    var id: String? = null,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var phone: String = "",
    var company: String = "",
    var creationDate: Timestamp? = null,
    var advisers: List<String> = emptyList()
)
