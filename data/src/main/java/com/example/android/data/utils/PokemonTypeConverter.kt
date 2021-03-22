package com.example.android.data.utils

import androidx.room.TypeConverter
import com.example.android.data.models.PokemonType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PokemonTypeConverter {

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<PokemonType?>? {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<PokemonType?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<PokemonType?>?): String? {
        return Gson().toJson(someObjects)
    }
}