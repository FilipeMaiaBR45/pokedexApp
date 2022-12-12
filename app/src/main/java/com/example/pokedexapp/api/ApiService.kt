package com.example.pokedexapp.api

import com.example.pokedexapp.api.pokemon.Pokemon
import com.example.pokedexapp.api.pokemon.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import javax.inject.Singleton


interface ApiService {
    @GET("/Biuni/PokemonGO-Pokedex/master/pokedex.json")
    fun getPokemons(): Call<PokemonResponse>
}