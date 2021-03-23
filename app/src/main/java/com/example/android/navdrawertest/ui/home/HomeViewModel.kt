package com.example.android.navdrawertest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.data.models.PokemonDTO
import com.example.android.data.repositories.PokemonRepository
import com.example.android.navdrawertest.commons.BaseViewModel

class HomeViewModel(private val repository: PokemonRepository) : BaseViewModel() {



    val pokemonDTOList: LiveData<List<PokemonDTO>> = repository.pokemonList



}