package com.company.poc.application.common

import com.company.poc.application.common.StringEncryption.Companion.encrypt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class StringEncryptionTest {
    private fun toEncrypt(): Stream<Arguments> {
        return Stream.of(
            Arguments.arguments("clark", 5, "hqfwp"),
            Arguments.arguments("cherry", 3, "fkhuub"),
            Arguments.arguments("blossom", 3, "eorvvrp"),
            Arguments.arguments("z", 1, "a")
        )
    }

    @ParameterizedTest
    @MethodSource("toEncrypt")
    fun should_encrypt(value: String, key: Int, expectedValue: String) {
        val result = value.encrypt(key)

        assertEquals(expectedValue, result)
    }
}
