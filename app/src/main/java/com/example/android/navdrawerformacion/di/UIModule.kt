package com.example.android.navdrawerformacion.di

import com.example.android.navdrawerformacion.home_activity.home.vm.HomeViewModel
import com.example.android.navdrawerformacion.home_activity.profile.vm.ProfileViewModel
import com.example.android.navdrawerformacion.splash_activity.SplashViewModelActivity
import com.example.android.navdrawerformacion.utils.SharedPokemonVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SharedPokemonVM() }
    viewModel { ProfileViewModel(get()) }
    viewModel { SplashViewModelActivity(get()) }
}