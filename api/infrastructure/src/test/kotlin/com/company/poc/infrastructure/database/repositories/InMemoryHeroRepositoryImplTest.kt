package com.company.poc.infrastructure.database.repositories

import com.company.poc.domain.entities.Hero
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class InMemoryHeroRepositoryImplTest {
    private val sut: InMemoryHeroRepositoryImpl = InMemoryHeroRepositoryImpl()

    @Test
    fun should_save() {
        val data = Hero.create("name", "first", "last", "1992-09-30", listOf())
        val total = this.sut.findAll()

        this.sut.save(data)

        val totalAfterSave = this.sut.findAll()

        assertNotEquals(total, totalAfterSave)
    }

    @Test
    fun should_not_exist_by_name() {
        val name = "name"

        val result = this.sut.isExisting(name)

        assertFalse(result)
        // TODO: verify that data is persisted
    }

    @Test
    fun should_find_all() {
        val result = sut.findAll()

        // TODO: verify that data is persisted
    }

    // TODO: add missing test
}
