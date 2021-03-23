package com.example.android.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.data.commons.Constants

@Entity(tableName = Constants.TABLE_PROFILE_DATA)
data class ProfileData(
        @PrimaryKey
        var id: Int = 1,
        var name: String,
        var surnameOne: String,
        var surnameTwo: String,
        var postalAddress: String
)