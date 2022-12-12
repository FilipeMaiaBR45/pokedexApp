package com.example.pokedexapp.homeFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.api.ApiRepository
import com.example.pokedexapp.api.pokemon.Pokemon
import com.example.pokedexapp.api.pokemon.PokemonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    private val _pokemonResponse : MutableLiveData<PokemonResponse> = MutableLiveData()
    val pokemonResponse : LiveData<PokemonResponse> = _pokemonResponse

    private val _pokemon : MutableLiveData<Pokemon> = MutableLiveData()
    val pokemon : LiveData<Pokemon> = _pokemon

    private val _listPokemon : MutableLiveData<List<Pokemon>> = MutableLiveData()
    val listPokemon : LiveData<List<Pokemon>> =_listPokemon

    fun getPokemons(){
        viewModelScope.launch(Dispatchers.IO) {
            val response : Call<PokemonResponse> = apiRepository.getPokemons()
           response.enqueue(object : Callback<PokemonResponse>{
               override fun onResponse(
                   call: Call<PokemonResponse>,
                   response: Response<PokemonResponse>
               ) {
                   if (response.code() == 200){
                       Log.i("responseee", "${response.body()!!.pokemon}")
                      val list = response.body()!!.pokemon as List<Pokemon>
                       _listPokemon.postValue(list.toList())
                       Log.i("responseee", "${list.toList()}")
                   }
               }

               override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                   Log.i("responseee", "Erro na api")
               }

           })


        }
    }

//    fun getPokemons(){
//        viewModelScope.launch(Dispatchers.IO) {
//            val response : List<Pokemon> = apiRepository.getPokemons()
//            _listPokemon.postValue(response)
//        }
//    }


}