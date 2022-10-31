package com.company.poc.application.common.entities

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ListResultTest {
    @Test
    fun should_create_obj() {
        val total = 2
        val items = listOf(1, 2, 3)
        val obj = ListResult.of(total, items)

        Assertions.assertEquals(total, obj.total)
        Assertions.assertEquals(items, obj.items)
    }
}
