package com.company.poc.application.heros.add

import com.company.poc.application.common.exceptions.DuplicateException
import com.company.poc.application.common.interfaces.HeroRepository
import com.company.poc.domain.entities.Hero
import com.trendyol.kediatr.CommandWithResultHandler
import org.springframework.stereotype.Component

@Component
internal class AddHeroCommandHandler(
    private val repo: HeroRepository
) : CommandWithResultHandler<AddHeroCommand, Hero> {
    override fun handle(command: AddHeroCommand): Hero {
        if (this.repo.isExisting(command.name)) {
            throw DuplicateException(
                "${Hero::class.java.simpleName} with name '${command.name}' already exists"
            )
        }

        val hero = Hero.create(
            command.name,
            command.firstName,
            command.lastName,
            command.birthday,
            command.superpowers
        )
        this.repo.save(hero)

        return hero
    }
}
