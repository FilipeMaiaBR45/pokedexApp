package com.example.pokedexapp.api

import com.example.pokedexapp.api.pokemon.PokemonResponse
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ServiceScoped
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Call
import javax.inject.Inject

//@ActivityScoped
@ViewModelScoped
class ApiRepository @Inject constructor(
   private val apiService: ApiService
) {
     fun getPokemons() = apiService.getPokemons()
}