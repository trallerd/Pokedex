package com.example.pokedex.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
class Favorite(
    @PrimaryKey
    var id: Int,
    var name: String,
    var types: String,
    var abilities: String,
    var species: String,
    var height: Int,
    var weight: Int,
    var image: String
) {
}