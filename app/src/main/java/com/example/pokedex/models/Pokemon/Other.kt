package com.example.pokedex.models.Pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: DreamWorld,
    @SerializedName("official-artwork")val officialArtwork:OfficialArtwork
)