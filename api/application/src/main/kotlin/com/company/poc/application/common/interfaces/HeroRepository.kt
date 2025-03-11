package com.company.poc.application.common.interfaces

import com.company.poc.application.common.entities.ListResult
import com.company.poc.domain.entities.Hero
import com.company.poc.domain.entities.SuperPower

interface HeroRepository {
    fun save(hero: Hero)

    fun findAll(): ListResult<Hero>
    fun findAll(superpowers: List<SuperPower>): ListResult<Hero>
    fun isExisting(name: String): Boolean
    fun findByName(name: String): Hero
}
