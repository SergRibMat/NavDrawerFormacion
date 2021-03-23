package com.example.android.data.di

import com.example.android.data.di.providers.*
import org.koin.dsl.module

val dataModule = module {
    single { provideMockInterceptor(get()) }
    single { provideGson() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get(), get()) }
    single { providePokemonApi(get()) }
    single { providePokemonRepository(get(), get()) }
    single { providePokemonDatabase(get()) }
}