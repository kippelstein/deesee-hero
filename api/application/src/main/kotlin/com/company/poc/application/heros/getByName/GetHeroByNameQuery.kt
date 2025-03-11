package com.company.poc.application.heros.getBySuperpower

import com.company.poc.domain.entities.Hero
import com.trendyol.kediatr.Query

data class GetHeroByNameQuery(
    val name: String,
) : Query<Hero>
