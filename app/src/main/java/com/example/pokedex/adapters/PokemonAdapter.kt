package com.example.pokedex.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.pokedex.R
import com.example.pokedex.database.AppDatabase
import com.example.pokedex.database.daos.FavoriteDAO
import com.example.pokedex.models.Favorite
import com.example.pokedex.models.Pokemon.Pokemon
import com.example.pokedex.models.PokemonList.Result
import com.example.pokedex.network.dao.PokemonDAO
import kotlinx.android.synthetic.main.pokemon_file.view.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class PokemonAdapter(context: Context): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private val daoF: FavoriteDAO
    private val dao: PokemonDAO = PokemonDAO()
    private val pokemonsF: MutableList<Favorite>
    private var pokemons = listOf<Result>()

    init {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "pokemon-db"
        )
            .allowMainThreadQueries()
            .build()

        daoF = db.favoriteDAO()
        dao.getALL(0,100) { apiResult ->
            pokemons = apiResult.results.toMutableList()
            notifyDataSetChanged()
        }
        pokemonsF = daoF.getALL().toMutableList()
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
        val pokemon = pokemons!![position]
        holder.fillView(pokemon)
    }

    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        fun fillView(pokemon: Result){
            itemView.PokemonName.text = pokemon.name.toUpperCase()

        }
    }


}