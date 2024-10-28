package com.asesorhub.api.service.advisor.impl

import com.asesorhub.api.controller.advisor.dto.request.AdvisorRequestJson
import com.asesorhub.api.controller.advisor.dto.response.AdvisorResponseJson
import com.asesorhub.api.persistance.advisor.entity.Advisor
import com.asesorhub.api.persistance.advisor.repository.AdvisorMapperRepository
import com.asesorhub.api.service.advisor.AdvisorService
import com.asesorhub.api.service.advisor.mapper.AdvisorMapper
import org.springframework.stereotype.Service

@Service
class AdvisorServiceImpl(private var advisorMapperRepository: AdvisorMapperRepository) : AdvisorService {

    override fun findAll(): List<AdvisorResponseJson> {
        val recruiterList = advisorMapperRepository.findAll()
        val recruiterMapped = recruiterList.map { advisor: Advisor ->
            AdvisorMapper.INSTANCE.recruiterToRecruiterResponseJson(advisor)
        }
        return recruiterMapped
    }

    override fun create(recruiter: AdvisorRequestJson): AdvisorResponseJson {
        val recruiterMapped =
            AdvisorMapper.INSTANCE.recruiterRequestJsonToRecruiter(recruiter)
        val newRecruiter = advisorMapperRepository.save(recruiterMapped)
        return AdvisorMapper.INSTANCE.recruiterToRecruiterResponseJson(
            newRecruiter
        )
    }
}