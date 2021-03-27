package com.example.android.navdrawerformacion.home_activity.profile.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.data.models.ProfileData
import com.example.android.data.repositories.PokemonRepository
import com.example.android.navdrawerformacion.commons.BaseViewModel
import com.example.android.navdrawerformacion.commons.noDataFilter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: PokemonRepository) : BaseViewModel() {

    val profileData: LiveData<ProfileData> = repository.profileData


    fun saveProfileData(profileData: ProfileData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveProfileData(checkIfLiveDataNull(profileData))
        }
    }

    //Checks if livedata is null
    private fun checkIfLiveDataNull(profileData: ProfileData): ProfileData =
            if (this.profileData.value == null)
                profileData
            else
                profileData.noDataFilter(this.profileData.value!!)
}