package com.example.pokedex.network.dao

import android.util.Log
import com.example.pokedex.models.PokemonList.PokemonList
import com.example.pokedex.network.services.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonDAO {
    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service: PokemonService
        get() = retrofit.create(PokemonService::class.java)


    fun getALL(limit:Long, offset:Long,finished: (PokemonList)->Unit){
        service.getAll(limit, offset).enqueue(object : Callback<PokemonList>{
            override fun onResponse(
                call: Call<PokemonList>,
                response: Response<PokemonList>
            ) {
                Log.i("AAA" , response.body()!!.results.toString())
                if (response.body() != null) {
                    Log.i("AAA" , response.body()!!.results.toString())
                    finished(response.body()!!)
                }
            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                Log.i("Failure" , t.message.toString())
            }

        })
    }

}