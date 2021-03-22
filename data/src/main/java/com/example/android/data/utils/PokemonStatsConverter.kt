package com.example.android.data.utils

import androidx.room.TypeConverter
import com.example.android.data.models.PokemonStats
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PokemonStatsConverter {
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<PokemonStats?>? {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<PokemonStats?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<PokemonStats?>?): String? {
        return Gson().toJson(someObjects)
    }
}