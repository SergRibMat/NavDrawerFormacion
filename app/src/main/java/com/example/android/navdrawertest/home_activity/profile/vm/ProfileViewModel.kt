package com.example.android.navdrawertest.home_activity.profile.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.data.models.ProfileData
import com.example.android.data.repositories.PokemonRepository
import com.example.android.navdrawertest.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: PokemonRepository) : BaseViewModel() {

    val profileData: LiveData<ProfileData> = repository.profileData


    fun saveProfileData(profileData: ProfileData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveProfileData(profileData)
        }
    }
}