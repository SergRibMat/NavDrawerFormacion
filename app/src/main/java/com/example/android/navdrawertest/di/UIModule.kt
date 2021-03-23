package com.example.android.navdrawertest.di

import com.example.android.navdrawertest.SplashViewModelActivity
import com.example.android.navdrawertest.ui.home.HomeViewModel
import com.example.android.navdrawertest.ui.slideshow.ProfileViewModel
import com.example.android.navdrawertest.utils.SharedPokemonVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SharedPokemonVM() }
    viewModel { ProfileViewModel(get()) }
    viewModel { SplashViewModelActivity(get()) }
}