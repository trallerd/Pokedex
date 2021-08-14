package com.example.pokedex.models.Pokemon

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")val redBlue: RedBlue,
    val yellow: Yellow
)