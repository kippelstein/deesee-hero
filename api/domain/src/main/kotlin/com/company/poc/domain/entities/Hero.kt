package com.company.poc.domain.entities

data class Hero private constructor(
    val name: String,
    val identity: Identity,
    val birthday: String,
    val superpowers: List<SuperPower>
) {
    init {
        require(name.isNotBlank()) { "Name is not allowed to be blank '$name'" }
        // TODO: validate birthday
    }

    companion object {
        fun create(
            name: String,
            firstName: String,
            lastName: String,
            birthday: String,
            superpowers: List<SuperPower>
        ) = Hero(
            name,
            Identity.create(firstName, lastName),
            birthday,
            superpowers
        )
    }
}

