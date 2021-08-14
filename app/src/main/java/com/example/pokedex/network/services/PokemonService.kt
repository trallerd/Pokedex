package com.example.pokedex.network.services

import com.example.pokedex.models.Pokemon.Pokemon
import com.example.pokedex.models.PokemonList.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun getAll(@Query("limit") limit: Long,
               @Query("offset") offset: Long
    ): Call<PokemonList>

    @GET("pokemon/{name}")
    fun getByName(@Path("name") name: String): Call<Pokemon>

}