package com.example.pokedex.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Controller
import com.example.pokedex.R
import com.example.pokedex.models.PokemonList.Result
import com.example.pokedex.network.dao.PokemonDAO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_file.view.*
import java.util.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class PokemonAdapter(): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private val dao: PokemonDAO = PokemonDAO()
    private var pokemons = listOf<Result>()

    init {
        dao.getALL(0,100) { apiResult ->
            pokemons = apiResult.results
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

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
        fun fillView(pokemon: Result){
            Controller.fav = false
            itemView.pokheight.text = pokemon.name.uppercase(Locale.getDefault())
            dao.getByName(pokemon.name){pokemonAPI ->
                Picasso.with(
                    itemView.context
                ).load(
                    pokemonAPI.sprites.front_default
                ).into(itemView.avatar)
            }
            itemView.pokemon_card.setOnClickListener {
                Controller.pokemon = pokemon.name
                val navController = Navigation.findNavController(it)
                navController.navigate(R.id.home_to_details)
            }
        }
    }


}