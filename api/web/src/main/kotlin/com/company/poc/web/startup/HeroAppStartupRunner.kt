package com.company.poc.web.startup

import com.company.poc.application.common.exceptions.DuplicateException
import com.company.poc.application.heros.add.AddHeroCommand
import com.company.poc.domain.entities.SuperPower
import com.trendyol.kediatr.CommandBus
import org.slf4j.Logger
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
internal class HeroAppStartupRunner(
    val commandBus: CommandBus,
    val logger: Logger
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        createHeros()
    }

    private fun createHeros() {
        data.forEach {
            try {
                val result = commandBus.executeCommand(it)

                logger.info("Hero '${result.name}' handled")
            } catch (exc: DuplicateException) {
                logger.info("Hero '$it' already exists")
            }
        }
    }

    val data: Array<AddHeroCommand> = arrayOf(
        AddHeroCommand(
            "superman",
            "clark",
            "kent",
            "1977-04-18",
            listOf(SuperPower.FLIGHT, SuperPower.STRENGTH, SuperPower.INVULNERABILITY)
        ),
        AddHeroCommand(
            "deadpool",
            "wade",
            "wilson",
            "1973-11-22",
            listOf(SuperPower.HEALING)
        ),
        AddHeroCommand(
            "batman",
            "bruce",
            "wayne",
            "1915-04-17",
            listOf()
        ),
        AddHeroCommand(
            "aquaman",
            "arthur",
            "curry",
            "1986-01-29",
            listOf(SuperPower.FLIGHT, SuperPower.HEALING, SuperPower.STRENGTH)
        ),
        AddHeroCommand(
            "flash",
            "barry",
            "allen",
            "1992-09-30",
            listOf(SuperPower.SPEED, SuperPower.HEALING)
        ),
    )
}
