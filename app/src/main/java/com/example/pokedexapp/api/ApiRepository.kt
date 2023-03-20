package com.example.pokedexapp.api

import retrofit2.Call
import javax.inject.Inject

//@ActivityScoped
class ApiRepository @Inject constructor(
   private val apiService: ApiService
) {
     fun getPokemons() = apiService.getPokemons()
}