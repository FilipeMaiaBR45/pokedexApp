package com.example.pokedexapp.detalhesFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment

        Picasso.get().load("https://www.serebii.net/pokemongo/pokemon/001.png").resize(500,500).into(binding.imageView)

        return binding.root
    }


}