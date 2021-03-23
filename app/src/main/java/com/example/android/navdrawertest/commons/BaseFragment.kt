package com.example.android.navdrawertest.commons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.android.data.models.PokemonStats
import com.example.android.data.models.PokemonType

abstract class BaseFragment: Fragment() {

    abstract fun loadObservers()
    abstract fun loadListeners()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadObservers()
        loadListeners()
    }
}