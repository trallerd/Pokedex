package com.example.pokedex.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.adapters.FavoriteAdapter
import kotlinx.android.synthetic.main.fragment_favorites.view.*

class Favorites : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_favorites, container, false)
        view.favoritesList.adapter = FavoriteAdapter(view.context)
        view.favoritesList.layoutManager = LinearLayoutManager(
            context ,
            LinearLayoutManager.VERTICAL ,
            false
        )

        return view
    }
}