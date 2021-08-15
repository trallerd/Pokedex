package com.example.pokedex.fragments

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.pokedex.Controller
import com.example.pokedex.R
import com.example.pokedex.models.Pokemon.Pokemon
import com.example.pokedex.network.dao.PokemonDAO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import java.net.URL
import java.util.*


class Details : Fragment() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_details, container, false)
        val dao = PokemonDAO()
        dao.getByName(Controller.pokemon){ pokemonAPI ->
            loadImage(pokemonAPI.sprites.front_default)
            fillView(pokemonAPI)
        }
        return view
    }

    private fun loadImage(from: String) = Picasso.with(context).load(from).into(pokemon_avatar)

    private fun fillView(pokemon: Pokemon){
        descName.text = pokemon.name.uppercase(Locale.getDefault())
        var list = ""
        for(type in pokemon.types){
            list += " " + type.type.name
        }
        var abList = ""
        for(ability in pokemon.abilities){
            abList += " " + ability.ability.name
        }
        descType2.text = list
        descAbility2.text = abList
        descSpecies2.text = pokemon.species.name
        descHeight2.text = pokemon.height.toString()
        descWeight2.text = pokemon.weight.toString()
        descID2.text = pokemon.id.toString()
    }

}