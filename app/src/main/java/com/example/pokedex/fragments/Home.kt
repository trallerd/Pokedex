package com.example.pokedex.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.adapters.PokemonAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

class Home : Fragment() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
    ) : View? {
        val view = inflater.inflate(R.layout.fragment_home , container , false)
        view.pokemonList.adapter = PokemonAdapter()
        view.pokemonList.layoutManager = LinearLayoutManager(
            context ,
            LinearLayoutManager.VERTICAL ,
            false
        )

        return view
    }




}