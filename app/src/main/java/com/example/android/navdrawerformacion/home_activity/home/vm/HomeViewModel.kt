package com.example.android.navdrawerformacion.home_activity.home.vm

import androidx.lifecycle.LiveData
import com.example.android.data.models.PokemonDTO
import com.example.android.data.repositories.PokemonRepository
import com.example.android.navdrawerformacion.commons.BaseViewModel

class HomeViewModel(private val repository: PokemonRepository) : BaseViewModel() {

    val pokemonDTOList: LiveData<List<PokemonDTO>> = repository.pokemonList

}