package com.example.pokedex.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
class Favorite(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    var types: String,
) {
}