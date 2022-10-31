package com.company.poc.domain.entities

data class Identity private constructor(
    val firstName: String,
    val lastName: String,
) {

    init {
        require(firstName.isNotBlank()) { "FirstName is not allowed to be blank '$firstName'" }
        require(lastName.isNotBlank()) { "LastName is not allowed to be blank '$lastName'" }
    }

    companion object {
        fun create(
            firstName: String,
            lastName: String
        ) = Identity(firstName, lastName)
    }
}
