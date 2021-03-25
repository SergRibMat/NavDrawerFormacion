package com.example.android.navdrawertest.splash_activity

import android.os.Bundle
import com.example.android.navdrawertest.commons.BaseActivity
import com.example.android.navdrawertest.databinding.ActivitySplashBinding
import com.example.android.navdrawertest.home_activity.MainActivity
import org.jetbrains.anko.startActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    private val presenter: SplashViewModelActivity by viewModel()

    private var _binding: ActivitySplashBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        presenter.loadPokemonIntoDatabase()

    }


    override fun loadObservers() {
        presenter.initMainActivity.observe(this, {
            if (it) {
                startActivity<MainActivity>()
                finish()
            }
        })
    }
}