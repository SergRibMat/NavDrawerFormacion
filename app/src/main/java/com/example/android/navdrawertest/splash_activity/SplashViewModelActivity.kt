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

    //when true, starts MainActivity
    private var _initMainActivity = SingleLiveEvent<Boolean>()
    val initMainActivity: LiveData<Boolean>
        get() = _initMainActivity


    fun loadPokemonIntoDatabase() {
        viewModelScope.launch(Dispatchers.IO) {

            for (id in 1..60) {
                when (val result = repository.getPokemonsAndSave(id)) {
                    is ResultHandler.Success -> {
                        //when success API call
                    }
                    else -> {
                        //when error API call
                    }
                }
                //execute when X number of calls have been made
                if (id == 20) {
                    //change value to start Main Activity
                    _initMainActivity.postValue(true)
                }
            }
        }
    }
}