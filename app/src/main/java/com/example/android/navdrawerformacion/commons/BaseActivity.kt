package com.example.android.navdrawerformacion.commons

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadObservers()
    }

    abstract fun loadObservers()

    fun showToast(context: Context, text: String) {
        Toast.makeText(context, "$text", Toast.LENGTH_SHORT).show()
    }


}