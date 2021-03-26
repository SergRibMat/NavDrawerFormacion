package com.example.android.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.android.data.commons.BaseRepository
import com.example.android.data.local.PokemonDatabase
import com.example.android.data.models.PokemonDTO
import com.example.android.data.models.ProfileData
import com.example.android.data.remote.IPokemonAPI
import com.example.android.data.remote.ResultHandler

class PokemonRepository(private val api: IPokemonAPI, private val pokemonDB: PokemonDatabase) : BaseRepository() {

    val pokemonList: LiveData<List<PokemonDTO>> by lazy {
        pokemonDB.pokemonDatabaseDao().loadPokemons()
    }


    val profileData: LiveData<ProfileData> by lazy {
        pokemonDB.pokemonDatabaseDao().loadProfileData()
    }


    //API
    suspend fun getPokemonsAndSave(id: Int): ResultHandler<String> {
        //Call to API and save in Room

        return when (val result = safeApiCall(call = { api.getPokemons(id) })) {
            is ResultHandler.Success -> {

                result.data.let {
                    //Save data in Room
                    pokemonDB.pokemonDatabaseDao().savePokemon(it)
                }
                ResultHandler.Success("Successful update")
            }
            is ResultHandler.GenericError -> result
            is ResultHandler.HttpError -> result
            is ResultHandler.NetworkError -> result
        }
    }


    fun saveProfileData(profileData: ProfileData) {
        Log.i("Mensage", "Name:  ${profileData.name}")
        pokemonDB.pokemonDatabaseDao().saveProfileData(profileData)
    }
}