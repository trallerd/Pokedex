package com.example.pokedex.models

data class Pokemon(
    var name: String,
    var type: String,
    var ability: String,
) {
    companion object{
        fun getALL(): List<Pokemon> {
            return listOf(
                Pokemon("Pokemon 1","Type 1", "Ability 1"),
                Pokemon("Pokemon 2","Type 2", "Ability 2"),
                Pokemon("Pokemon 3","Type 3", "Ability 3"),
                Pokemon("Pokemon 4","Type 4", "Ability 4"),
                Pokemon("Pokemon 5","Type 5", "Ability 5"),
                Pokemon("Pokemon 6","Type 6", "Ability 6"),
                Pokemon("Pokemon 7","Type 7", "Ability 7"),
                Pokemon("Pokemon 8","Type 8", "Ability 8"),
            )
        }
    }
}