package com.company.poc.domain.entities

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class IdentityTest {
    @Test
    fun should_create(){
        val res = Identity.create(
            "first",
            "last",
        )

        Assertions.assertEquals("first", res.firstName)
        Assertions.assertEquals("last", res.lastName)
    }

    // TODO: write more test e.g. for validation
}
