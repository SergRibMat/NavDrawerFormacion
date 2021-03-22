package com.example.android.data.di.providers

import android.app.Application
import com.example.android.data.BuildConfig
import com.example.android.data.local.PokemonDatabase
import com.example.android.data.remote.IPokemonAPI
import com.example.android.data.remote.interceptors.MockInterceptor
import com.example.android.data.repositories.PokemonRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun provideOkHttpClient(mockInterceptor: Interceptor?): OkHttpClient {
    val client = OkHttpClient().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
    if (BuildConfig.FLAVOR == "mock"){
        mockInterceptor?.let {
            client.addInterceptor(mockInterceptor)
        }
    }
    return client.build()
}

fun provideMockInterceptor(application: Application): Interceptor {
    return MockInterceptor(application)
}

fun provideGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .serializeNulls()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .create()
}

fun provideRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
    .client(httpClient)
    .baseUrl(BuildConfig.BaseURL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

fun providePokemonApi (retrofit: Retrofit): IPokemonAPI = retrofit
    .create(IPokemonAPI::class.java)

fun providePokemonDatabase(application: Application): PokemonDatabase {
    return PokemonDatabase.getInstance(application)
}

fun providePokemonRepository(retrofit: IPokemonAPI, pokemonDB: PokemonDatabase): PokemonRepository = PokemonRepository(retrofit, pokemonDB)
