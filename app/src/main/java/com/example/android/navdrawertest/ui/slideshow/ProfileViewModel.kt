package com.example.android.navdrawertest.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.data.models.ProfileData
import com.example.android.data.repositories.PokemonRepository
import com.example.android.navdrawertest.commons.BaseViewModel

class ProfileViewModel(private val repository: PokemonRepository) : BaseViewModel() {

    val profileData: LiveData<ProfileData> = repository.profileData


    fun saveProfileData(profileData: ProfileData){
        repository.saveProfileData(profileData)
    }


}