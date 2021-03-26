package com.example.android.data.remote

import com.example.android.data.models.PokemonDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface IPokemonAPI {
    //get single pokemon with ID
    @GET("pokemon/{id}")
    suspend fun getPokemons(@Path("id") pokemonId: Int): Response<PokemonDTO>

}