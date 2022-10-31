package com.company.poc.web.models.common

import org.assertj.core.util.Lists
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ListResultDtoTest {
    @Test
    fun should_map() {
        val test1 = "test1"
        val test2 = "test2"
        val test = ListResultDto(2, Lists.list(test1, test2))

        Assertions.assertEquals(2, test.total)
        Assertions.assertEquals(test1, test.items[0])
        Assertions.assertEquals(test2, test.items[1])
    }
}
