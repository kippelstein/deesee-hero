package com.company.poc.application.heros.getBySuperpower

import com.company.poc.application.common.entities.ListResult
import com.company.poc.domain.entities.Hero
import com.company.poc.domain.entities.SuperPower
import com.trendyol.kediatr.Query
data class GetHeroBySuperpowerQuery(
    val superpowers: List<SuperPower>?,
    val encryptionKey: Int?,
) : Query<ListResult<Hero>>
