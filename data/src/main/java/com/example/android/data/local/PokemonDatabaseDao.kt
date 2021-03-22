package com.example.android.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.data.commons.Constants
import com.example.android.data.models.PokemonDTO
import com.example.android.data.models.ProfileData

@Dao
interface PokemonDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePokemon(pokemon: PokemonDTO)

    @Query("SELECT * FROM `${Constants.TABLE_POKEMON}`")
    fun loadPokemons(): LiveData<List<PokemonDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProfileData(profileData: ProfileData)

    @Query("SELECT * FROM `${Constants.TABLE_PROFILE_DATA}`")
    fun loadProfileData(): LiveData<ProfileData>

}