package com.example.android.navdrawertest.commons

fun String.emptyString(): String = if (this.isNullOrEmpty()) "No data" else this