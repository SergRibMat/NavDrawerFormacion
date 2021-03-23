package com.example.android.navdrawertest

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.data.remote.ResultHandler
import com.example.android.data.repositories.PokemonRepository
import com.example.android.navdrawertest.commons.BaseViewModel
import com.example.android.navdrawertest.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModelActivity(private val repository: PokemonRepository): BaseViewModel() {

    private var _initMyActivity = SingleLiveEvent<Boolean>()
    val initMyActivity: LiveData<Boolean>
        get() = _initMyActivity

    fun loadPokemonIntoDatabase(){
        for (id in 1..80) {
            viewModelScope.launch(Dispatchers.IO) {

                when (val result = repository.getPokemonsAndSave(id)) {
                    is ResultHandler.Success -> {
                        showMessage(result.data)
                        _initMyActivity.postValue(true)
                    }
                    else -> {
                        setShowError(result)
                        _initMyActivity.postValue(true)
                    }
                }

            }
        }


    }


}