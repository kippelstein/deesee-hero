package com.company.poc.infrastructure.database.repositories

import com.company.poc.application.common.entities.ListResult
import com.company.poc.application.common.exceptions.NotFoundException
import com.company.poc.application.common.interfaces.HeroRepository
import com.company.poc.domain.entities.Hero
import com.company.poc.domain.entities.SuperPower
import org.springframework.stereotype.Service

@Service
internal class InMemoryHeroRepositoryImpl(
) : HeroRepository {
    private val heros = mutableListOf<Hero>()

    override fun save(hero: Hero) {
        heros.add(hero)
    }

    override fun findAll(): ListResult<Hero> {
        return ListResult.of(heros.count(), heros)
    }

    override fun findAll(superpowers: List<SuperPower>): ListResult<Hero> {
        if (superpowers.isEmpty())
            return ListResult.of(heros.count(), heros)

        val result = heros.filter { it -> it.superpowers.any { it in superpowers } }

        if (result.isEmpty()) {
            throw NotFoundException("No heros found with given superpowers")
        }

        return ListResult.of(heros.count(), result)
    }

    override fun isExisting(name: String): Boolean {
        return heros.firstOrNull { it.name == name} != null
    }

    override fun findByName(name: String): Hero {
        val res = heros.firstOrNull { it.name.equals(name, true)};
        if (res == null) {
            throw NotFoundException("No hero found with the name '${name}'")
        }
        return res;
    }
}
