package com.example.pokedex.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.pokedex.Controller
import com.example.pokedex.R
import com.example.pokedex.database.AppDatabase
import com.example.pokedex.database.daos.FavoriteDAO
import com.example.pokedex.models.Favorite
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.favorite_file.view.*
import kotlinx.android.synthetic.main.pokemon_file.view.*
import kotlinx.android.synthetic.main.pokemon_file.view.avatar
import kotlinx.android.synthetic.main.pokemon_file.view.pokemon_card
import kotlinx.android.synthetic.main.pokemon_file.view.pokheight

class FavoriteAdapter(context: Context): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private val dao: FavoriteDAO
    private var pokemons = listOf<Favorite>()

    init {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "favorites.db"
        )
            .allowMainThreadQueries()
            .build()

        dao = db.favoriteDAO()
        pokemons = dao.getALL()

    }

    fun add(pokemon: Favorite){
        dao.insert(pokemon)
    }

    fun delete(pokemon: Favorite){
        dao.delete(pokemon)
    }

    fun verifyById(id: Int): Boolean {
        return dao.verifyById(id)
    }

    override fun getItemCount() = pokemons.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.favorite_file,parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.fillView(pokemon)
    }

    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        fun fillView(favorite: Favorite){
            itemView.pokheight.text = favorite.name
            Picasso.with(
                itemView.context
            ).load(
                favorite.image
            ).into(itemView.avatar)
                Controller.pokemon = favorite.name
                itemView.pokname.text = favorite.name
                itemView.poktype.text = favorite.types
                itemView.pokability.text = favorite.abilities
                itemView.pokspecies.text = favorite.species
                itemView.pokheight.text = favorite.height.toString()
                itemView.pokweight.text = favorite.weight.toString()
                itemView.pokid.text = favorite.id.toString()
        }
    }
}