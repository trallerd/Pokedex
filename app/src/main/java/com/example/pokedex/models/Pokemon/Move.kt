package com.example.pokedex.models.Pokemon

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)