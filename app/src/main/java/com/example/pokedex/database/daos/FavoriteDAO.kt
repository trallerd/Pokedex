package com.example.pokedex.database.daos

import androidx.room.*
import com.example.pokedex.models.Favorite

@Dao
interface FavoriteDAO {
    @Query("SELECT * FROM favorites")
    fun getALL(): List<Favorite>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favorite: Favorite)

    @Delete
    fun delete(favorite: Favorite)
}