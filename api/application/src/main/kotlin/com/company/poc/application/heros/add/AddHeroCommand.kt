package com.company.poc.application.heros.add

import com.company.poc.domain.entities.Hero
import com.company.poc.domain.entities.SuperPower
import com.trendyol.kediatr.CommandWithResult

data class AddHeroCommand(
    val name: String,
    val firstName: String,
    val lastName: String,
    val birthday: String,
    val superpowers: List<SuperPower>
) : CommandWithResult<Hero>
