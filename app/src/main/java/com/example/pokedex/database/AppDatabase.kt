package com.example.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.database.daos.FavoriteDAO
import com.example.pokedex.models.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDAO(): FavoriteDAO
}