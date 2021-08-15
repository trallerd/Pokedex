package com.example.pokedex.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.pokedex.Controller
import com.example.pokedex.R
import com.example.pokedex.models.Pokemon.Pokemon
import com.example.pokedex.network.dao.PokemonDAO
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.pokemon_file.view.*
import java.util.*

class Details : Fragment() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_details, container, false)
        val dao = PokemonDAO()
        val build: AlertDialog.Builder = AlertDialog.Builder(view.context)
        build.setView(R.layout.activity_loading)
        build.setCancelable(false)
        val load: AlertDialog = build.create()
        dao.getByName(Controller.pokemon){ pokemonAPI ->
            descName.text = pokemonAPI.name.uppercase(Locale.getDefault())
            var list = ""
            for(type in pokemonAPI.types){
               list += " " + type.type.name
            }
            var abList = ""
            for(ability in pokemonAPI.abilities){
               abList += " " + ability.ability.name
            }
            descType2.text = list
            descAbility2.text = abList
            descSpecies2.text = pokemonAPI.species.name
            descHeight2.text = pokemonAPI.height.toString()
            descWeight2.text = pokemonAPI.weight.toString()
            descID2.text = pokemonAPI.id.toString()
            load.dismiss()
        }
        return view
    }
}