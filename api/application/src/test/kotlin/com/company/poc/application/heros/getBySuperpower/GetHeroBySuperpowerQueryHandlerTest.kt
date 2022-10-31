package com.company.poc.application.heros.getBySuperpower

import com.company.poc.application.common.entities.ListResult
import com.company.poc.application.common.interfaces.HeroRepository
import com.company.poc.domain.entities.Hero
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class GetHeroBySuperpowerQueryHandlerTest {
    private val sut: GetHeroBySuperpowerQueryHandler
    private val mockRepo: HeroRepository = mock()

    init {
        this.sut = GetHeroBySuperpowerQueryHandler(this.mockRepo)
    }

    @Test
    fun should_get_by_superpowers() {
        val heros = listOf(
            Hero.create("name", "clark", "kent", "1970-01-01", listOf())
        )
        val command = GetHeroBySuperpowerQuery(listOf(), 0)
        whenever(this.mockRepo.findAll(command.superpowers!!))
            .thenReturn(ListResult.of(1, heros))

        val result = this.sut.handle(command)

        assertEquals("clark", result.items.single().identity.firstName)
        verify(this.mockRepo, times(1)).findAll(command.superpowers!!)
    }

    @Test
    fun should_get_encrypted_by_superpowers() {
        val heros = listOf(
            Hero.create("name", "clark", "kent", "1970-01-01", listOf())
        )
        val command = GetHeroBySuperpowerQuery(listOf(), 5)
        whenever(this.mockRepo.findAll(command.superpowers!!))
            .thenReturn(ListResult.of(1, heros))

        val result = this.sut.handle(command)

        assertEquals("hqfwp", result.items.single().identity.firstName)
        verify(this.mockRepo, times(1)).findAll(command.superpowers!!)
    }

    // TODO: test all other case
}
