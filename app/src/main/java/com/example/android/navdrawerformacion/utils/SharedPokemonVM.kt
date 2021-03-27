package com.example.android.navdrawerformacion.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.data.models.PokemonDTO
import com.example.android.navdrawerformacion.commons.BaseViewModel

class SharedPokemonVM : BaseViewModel() {

    private var _pokemon = MutableLiveData<PokemonDTO>()
    val pokemon: LiveData<PokemonDTO>
        get() = _pokemon

    fun setPokemon(pokemon: PokemonDTO) {
        _pokemon.value = pokemon
    }
}