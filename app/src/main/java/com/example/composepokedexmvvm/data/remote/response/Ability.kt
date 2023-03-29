package com.example.composepokedexmvvm.data.remote.response

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)