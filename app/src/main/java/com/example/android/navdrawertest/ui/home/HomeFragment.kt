package com.example.android.navdrawertest.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.data.models.PokemonDTO
import com.example.android.navdrawertest.R
import com.example.android.navdrawertest.commons.BaseFragment
import com.example.android.navdrawertest.databinding.FragmentHomeBinding
import com.example.android.navdrawertest.utils.SharedPokemonVM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(), CellClickListener {

    private val presenter: HomeViewModel by viewModel()
    private val sharedPokemonVM: SharedPokemonVM by sharedViewModel()

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: AdapterPokemonGrid


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadObservers()

        Toast.makeText(context, "${presenter.showMessage.value}", Toast.LENGTH_SHORT).show()
        Toast.makeText(context, "${presenter.showError.value}", Toast.LENGTH_SHORT).show()
    }

    fun loadObservers(){

        presenter.pokemonDTOList.observe(viewLifecycleOwner, {
            adapter = AdapterPokemonGrid(it, this, requireContext())
            binding.photosGrid.adapter = adapter
            it.forEach {
                Log.i("Mensage", "${it.name} ${it.weight} ${it.image.image}")
            }
        })
    }

    override fun onCellClickListener(pokemon: PokemonDTO) {
        Toast.makeText(context, "${pokemon.name}", Toast.LENGTH_SHORT).show()
        sharedPokemonVM.setPokemon(pokemon)
        findNavController().navigate(R.id.action_nav_home_to_nav_gallery)

    }
}