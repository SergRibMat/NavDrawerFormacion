package com.example.android.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.android.data.commons.BaseRepository
import com.example.android.data.local.PokemonDatabase
import com.example.android.data.models.PokemonDTO
import com.example.android.data.models.ProfileData
import com.example.android.data.remote.IPokemonAPI
import com.example.android.data.remote.ResultHandler

class PokemonRepository(private val api: IPokemonAPI, private val pokemonDB: PokemonDatabase): BaseRepository() {

    val pokemonList: LiveData<List<PokemonDTO>> by lazy {
        pokemonDB.pokemonDatabaseDao().loadPokemons()
    }


    val profileData: LiveData<ProfileData> by lazy {
        pokemonDB.pokemonDatabaseDao().loadProfileData()
    }



    //API
    suspend fun getPokemonsAndSave(id: Int): ResultHandler<String> {
        //Call to API and save in Room

        when (val result = safeApiCall(call = { api.getPokemons(id) })) {
            is ResultHandler.Success -> {

                result.data.let {
                    //here is the response

                    //Save data in Room
                    pokemonDB.pokemonDatabaseDao().savePokemon(it)
                }
                //It is not necessary to return nothing, magic is done with liveData in Room
                return ResultHandler.Success("Successful update")
            }
            is ResultHandler.GenericError -> return result
            is ResultHandler.HttpError -> return result
            is ResultHandler.NetworkError -> return result
        }




    }

    fun saveProfileData(profileData: ProfileData){
        Log.i("Mensage", "Name:  ${profileData.name}")
        pokemonDB.pokemonDatabaseDao().saveProfileData(profileData)
    }

}