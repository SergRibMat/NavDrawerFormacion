package com.example.android.navdrawerformacion.commons

import com.example.android.data.models.ProfileData


fun String.emptyString(): String = if (this.isNullOrEmpty()) Constants.NO_DATA else this

//overrides empty data with database data
fun ProfileData.noDataFilter(profileData: ProfileData): ProfileData{

    if(name == Constants.NO_DATA){
        name = profileData.name
    }

    if(surnameOne == Constants.NO_DATA){
        surnameOne = profileData.surnameOne
    }

    if(surnameTwo == Constants.NO_DATA){
        surnameTwo = profileData.surnameTwo
    }

    if(postalAddress == Constants.NO_DATA){
        postalAddress = profileData.postalAddress
    }

    return this
}