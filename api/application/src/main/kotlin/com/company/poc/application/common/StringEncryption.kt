package com.company.poc.application.common

internal class StringEncryption {
    companion object {
        // formerly known as DeeSee Chiffre
        // TODO: add more validation to ensure e.g. that it will also work with higher chosen keys
        fun String.encrypt(key: Int): String {
            val abc = listOf(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
            )

            var encrypted = ""

            forEach {
                val index = abc.indexOf(it.lowercaseChar())
                val newIndex = index + key

                if (newIndex >= abc.count()) {
                    val diff = newIndex - abc.count()
                    encrypted += abc[diff]
                } else {
                    encrypted += abc[newIndex]
                }
            }

            return encrypted
        }
    }
}
