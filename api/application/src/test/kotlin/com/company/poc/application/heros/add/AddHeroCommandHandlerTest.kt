package com.company.poc.application.heros.add

import com.company.poc.application.common.exceptions.DuplicateException
import com.company.poc.application.common.interfaces.HeroRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.*

internal class AddHeroCommandHandlerTest {
    private val sut: AddHeroCommandHandler
    private val mockRepo: HeroRepository = mock()

    init {
        this.sut = AddHeroCommandHandler(this.mockRepo)
    }

    @Test
    fun should_insert() {
        val command = createCommand()
        whenever(this.mockRepo.isExisting(command.name)).thenReturn(false)

        val result = this.sut.handle(command)

        verify(this.mockRepo, times(1)).isExisting(command.name)
        verify(this.mockRepo, times(1)).save(result)
    }

    @Test
    fun should_throw_duplicate_exception() {
        val command = createCommand()
        whenever(this.mockRepo.isExisting(command.name)).thenReturn(true)

        val exc = assertThrows<DuplicateException> {
            this.sut.handle(command)
        }

        assertTrue(exc.message!!.contains(command.name))
        verify(this.mockRepo, times(1)).isExisting(command.name)
        verify(this.mockRepo, times(0)).save(any())
    }

    private fun createCommand(): AddHeroCommand =
        AddHeroCommand(
            "name",
            "first",
            "last",
            "1992-09-30",
            listOf()
        )
}
