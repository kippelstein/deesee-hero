package com.company.poc.web.models

import com.company.poc.application.common.entities.ListResult
import com.company.poc.domain.entities.Hero
import com.company.poc.domain.entities.SuperPower
import com.company.poc.web.models.common.ListResultDto

data class HeroDto(
    val name: String,
    val identity: String,
    val birthday: String,
    val superpowers: List<SuperPower>
)

internal fun ListResult<Hero>.toDto(): ListResultDto<HeroDto> {
    return ListResultDto(total, items.toDto())
}

internal fun List<Hero>.toDto(): List<HeroDto> {
    return this.map { domain -> domain.toDto() }
}

internal fun Hero.toDto(): HeroDto {
    return HeroDto(
        name,
        "${identity.firstName} ${identity.lastName}",
        birthday,
        superpowers
    )
}
