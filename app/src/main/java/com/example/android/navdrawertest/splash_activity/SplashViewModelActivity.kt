package com.example.android.navdrawertest.splash_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.data.remote.ResultHandler
import com.example.android.data.repositories.PokemonRepository
import com.example.android.navdrawertest.commons.BaseViewModel
import com.example.android.navdrawertest.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModelActivity(private val repository: PokemonRepository) : BaseViewModel() {

    private var _initMyActivity = SingleLiveEvent<Boolean>()
    val initMyActivity: LiveData<Boolean>
        get() = _initMyActivity


    fun loadPokemonIntoDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            for (id in 1..40) {
                when (val result = repository.getPokemonsAndSave(id)) {
                    is ResultHandler.Success -> {
                        showMessage(result.data)
                    }
                    else -> {
                        setShowError(result)
                    }
                }
                if (id == 20) {
                    _initMyActivity.postValue(true)
                }
            }
        }
    }
}