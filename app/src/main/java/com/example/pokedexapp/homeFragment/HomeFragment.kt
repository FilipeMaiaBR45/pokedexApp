package com.example.pokedexapp.homeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.FragmentHomeBinding
import com.example.pokedexapp.databinding.ItemPokemonBinding
import com.example.pokedexapp.homeFragment.adapter.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    val viewmodel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner

        viewmodel.getPokemons()

        Log.i("responseee", "${viewmodel.listPokemon.value}")

        val adapter = PokemonAdapter()

        binding.recyclerview.apply {
            this.adapter = adapter

        }


        viewmodel.listPokemon.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.toList())
            Log.i("responseee", "lista do viewmodel ${it}")
            Log.i("responseee", "lista do viewmodel ${it[150]}")

        })

        binding.recyclerview.addOnItemTouchListener(
            RecyclerView(binding.recyclerview, object : com.example.pokedexapp.homeFragment.RecyclerView.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    //var bundle = Bundle();
                    //Navigation.findNavController(view).navigate(R.id.navigation_notifications, bundle)
                    Navigation.findNavController(binding.recyclerview).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(adapter.getItemId(position)))

                    Toast.makeText(requireContext(), "Toque simples id:${adapter.getItemId(position)}", Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClick(view: View, position: Int) {
                    //var bundle = Bundle();
                   // Navigation.findNavController(_binding.recyclerview).navigate(HomeFragmentDirections.actionNavigationHomeToNavigationAltera2(adapter.getItemId(position)))

                    //Navigation.findNavController(view).navigate(R.id.navigation_altera, bundle)
                    // Navigation.findNavController(_binding.recyclerview).navigate(HomeFragmentDirections.actionNavigationHomeToNavigationAltera2(adapter.getItemId(position)))

                    Toast.makeText(requireContext(), "Toque longo", Toast.LENGTH_SHORT).show()
                }

            }))



        return binding.root
    }


}