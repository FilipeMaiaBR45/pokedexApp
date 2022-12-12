package com.example.pokedexapp.api.pokemon


import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("pokemon")
    val pokemon: List<Pokemon>
)