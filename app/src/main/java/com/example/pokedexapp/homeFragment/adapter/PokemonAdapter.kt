package com.example.pokedexapp.homeFragment.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapp.R
import com.example.pokedexapp.api.pokemon.Pokemon
import com.example.pokedexapp.api.pokemon.PokemonResponse
import com.example.pokedexapp.databinding.ItemPokemonBinding
import com.google.android.gms.common.api.Result
import javax.inject.Inject

class PokemonAdapter @Inject constructor() : androidx.recyclerview.widget.ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(PokemonDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val anime = getItem(position)
        holder.bind(anime)
    }

    override fun getItemId(position: Int): Long {
        var id = currentList[position].id
        //Log.i("idList", "$id")

        return id.toLong()

    }

    class PokemonViewHolder private constructor(var binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(pokemon: Pokemon) {
           binding.textViewNamePokemon.text = pokemon.name
//            binding.textViewNomeAnime.setOnClickListener {
//                Toast.makeText(binding.root.context, "CLicou no texto", Toast.LENGTH_SHORT).show()
//            }
        }

        companion object {
            fun from(parent: ViewGroup): PokemonViewHolder {

                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemPokemonBinding.inflate(inflater, parent, false)
                return PokemonViewHolder(binding)
            }
        }
    }

    class PokemonDiffCallBack : DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id.equals(newItem.id)
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.equals(newItem)
        }

    }
}