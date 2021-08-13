package com.example.pokedex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.models.Pokemon
import kotlinx.android.synthetic.main.pokemon_file.view.*

class PokemonAdapter: RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private val pokemons = Pokemon.getALL()
    override fun getItemCount() = pokemons.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.pokemon_file,parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.fillView(pokemon)
    }

    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        fun fillView(pokemon: Pokemon){
            itemView.PokemonName.text = pokemon.name
        }
    }
}