package com.example.android.navdrawertest.commons

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.data.models.PokemonStats
import com.example.android.data.models.PokemonType
import com.example.android.navdrawertest.R


fun printImageWithGlide(context: Context, img: String, imgView: ImageView) =
        Glide.with(context)
                .load(img)
                .apply(
                        RequestOptions()
                                .placeholder(R.drawable.loading_animation)
                                .error(R.drawable.ic_broken_image)
                )
                .into(imgView)

fun fromTypesListToString(list: List<PokemonType>): String {
    var str = ""

    list.forEach {
        str += "\n- ${it.type.name} "
    }

    return str
}

fun fromStatsToString(list: List<PokemonStats>): String {
    var str = ""

    list.forEach {
        str += "\n- ${it.stat.name}: ${it.baseStat}\n"

    }

    return str
}

