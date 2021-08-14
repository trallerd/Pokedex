package com.example.pokedex.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.pokedex.R
import com.example.pokedex.database.AppDatabase
import com.example.pokedex.database.daos.FavoriteDAO
import com.example.pokedex.models.Favorite
import kotlinx.android.synthetic.main.pokemon_file.view.*

class FavoriteAdapter(context: Context): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private val dao: FavoriteDAO
    private val pokemons: MutableList<Favorite>

    init {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "favorites.db"
        )
            .build()

        dao = db.favoriteDAO()
        pokemons = dao.getALL().toMutableList()

    }

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
        fun fillView(favorite: Favorite){
            itemView.PokemonName.text = favorite.name

        }
    }
}