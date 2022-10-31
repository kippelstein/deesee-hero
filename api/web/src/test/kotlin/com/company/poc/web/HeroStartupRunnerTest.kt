package com.company.poc.web

import com.company.poc.application.common.exceptions.DuplicateException
import com.company.poc.application.heros.add.AddHeroCommand
import com.company.poc.domain.entities.Hero
import com.company.poc.web.startup.HeroAppStartupRunner
import com.trendyol.kediatr.CommandBus
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import org.slf4j.Logger

internal class HeroStartupRunnerTest {
    private val sut: HeroAppStartupRunner
    private val mockCommandBus: CommandBus = mock()
    private val mockLogger: Logger = mock()

    init {
        this.sut = HeroAppStartupRunner(mockCommandBus, mockLogger)
    }

    @Test
    fun should_create_heros() {
        whenever(mockCommandBus.executeCommand(any<AddHeroCommand>())).thenReturn(
            Hero.create("name", "first", "last", "1992-09-30", listOf())
        )

        sut.run(null)

        verify(mockCommandBus, times(5)).executeCommand(any<AddHeroCommand>())
        verify(mockLogger, times(5)).info(any())
    }

    @Test
    fun should_log_info_if_hero_already_exists() {
        val exc = DuplicateException("exc")
        whenever(mockCommandBus.executeCommand(any<AddHeroCommand>()))
            .thenThrow(exc)

        sut.run(null)

        verify(mockCommandBus, times(5))
            .executeCommand(any<AddHeroCommand>())
        verify(mockLogger, times(5))
            .info(any())
    }
}
