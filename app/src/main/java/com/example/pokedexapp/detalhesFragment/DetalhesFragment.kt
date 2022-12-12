package com.example.pokedexapp.detalhesFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.FragmentDetalhesBinding
import com.example.pokedexapp.databinding.FragmentHomeBinding
import com.example.pokedexapp.homeFragment.HomeViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetalhesFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesBinding
    val viewmodel : DetalhesViewModel by viewModels()

    val args: DetalhesFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesBinding.inflate(layoutInflater, container, false)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner

        viewmodel.getPokemons()

        viewmodel.changePokemonId(args.id)

        //Picasso.get().load(viewmodel.listPokemon.value!![viewmodel.pokemonId.value!!.toInt() - 1].img).resize(500,500).into(binding.imageView)



       viewmodel.listPokemon.observe(viewLifecycleOwner, Observer {

           viewmodel.changePokemonValue(it[viewmodel.pokemonId.value!!.toInt() - 1])


       })

        // Inflate the layout for this fragment



        return binding.root
    }


}