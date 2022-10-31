package com.company.poc.domain.entities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class HeroTest {
    @Test
    fun should_create(){
        val res = Hero.create(
            "name",
            "first",
            "last",
            "1970-01-01",
            listOf(SuperPower.STRENGTH)
        )

        assertEquals("name", res.name)
        // TODO: validate all other properties
    }

    // TODO: write more test e.g. for validation
}

