package com.example.android.navdrawertest.home_activity.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.navdrawertest.commons.BaseFragment
import com.example.android.navdrawertest.commons.fromStatsToString
import com.example.android.navdrawertest.commons.fromTypesListToString
import com.example.android.navdrawertest.commons.printImageWithGlide
import com.example.android.navdrawertest.databinding.FragmentDetailBinding
import com.example.android.navdrawertest.utils.SharedPokemonVM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : BaseFragment() {

    private val sharedPokemonVM: SharedPokemonVM by sharedViewModel()

    private var _binding: FragmentDetailBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun loadObservers() {

    }


    override fun loadListeners() {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemon = sharedPokemonVM.pokemon.value
        pokemon?.let {
            //set text from pokemon object
            binding.tvName.text = "Pokemon name: ${it.name}"
            binding.tvBaseExperience.text = "Base Experience: ${it.baseExperience}"
            printImageWithGlide(requireContext(), it.image.image, binding.ivPokemonImage)
            binding.tvHeight.text = "Height: ${it.height}"
            binding.tvOrder.text = "Pokedex order: ${it.order}"
            binding.tvWeight.text = "Weight: ${it.weight}"
            val types = fromTypesListToString(it.types)
            binding.tvTypes.text = "Type:$types"
            val stats = fromStatsToString(it.stats)
            binding.tvStats.text = "Stats: $stats"
        }
    }
}