package com.asesorhub.api.service.advisor.mapper

import com.asesorhub.api.controller.advisor.dto.request.AdvisorRequestJson
import com.asesorhub.api.controller.advisor.dto.response.AdvisorResponseJson
import com.asesorhub.api.persistance.advisor.entity.Advisor
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper(
    componentModel = "spring",
    uses = [AdvisorRequestJson::class, AdvisorResponseJson::class, Advisor::class]
)
interface AdvisorMapper {

    companion object {
        val INSTANCE: AdvisorMapper = Mappers.getMapper(AdvisorMapper::class.java)
    }

    fun recruiterToRecruiterResponseJson(entity: Advisor): AdvisorResponseJson
    fun recruiterRequestJsonToRecruiter(json: AdvisorRequestJson): Advisor

}
