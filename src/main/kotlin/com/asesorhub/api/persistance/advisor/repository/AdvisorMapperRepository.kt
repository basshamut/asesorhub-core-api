package com.asesorhub.api.persistance.advisor.repository

import com.asesorhub.api.persistance.advisor.entity.Advisor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AdvisorMapperRepository : MongoRepository<Advisor, String> {
}