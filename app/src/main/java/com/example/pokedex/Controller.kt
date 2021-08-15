package com.example.pokedex

import android.app.Application
import com.example.pokedex.models.Favorite

class Controller: Application() {
    companion object{
        var pokemon = ""
        var fav = false
        var favorite = Favorite(0,"","","","",0,0,"")
    }
}