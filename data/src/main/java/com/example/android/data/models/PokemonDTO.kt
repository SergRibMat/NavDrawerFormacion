package com.example.android.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.android.data.commons.Constants
import com.example.android.data.utils.PokemonStatsConverter
import com.example.android.data.utils.PokemonTypeConverter
import com.google.gson.annotations.SerializedName

//Json and Room object
@Entity(tableName = Constants.TABLE_POKEMON)
data class PokemonDTO(
        var name: String,
        @SerializedName("sprites")
        @Embedded
        var image: PokemonImage,
        //transforms List into string with given class and vice versa
        @TypeConverters(PokemonStatsConverter::class)
        var stats: List<PokemonStats>,
        var weight: String,
        @SerializedName("base_experience")
        var baseExperience: String,
        @PrimaryKey
        var order: Int,
        var height: String,
        //transforms List into string with given class and vice versa
        @TypeConverters(PokemonTypeConverter::class)
        var types: List<PokemonType>
)

data class PokemonType(
        var slot: String,
        var type: Type
)


data class PokemonStats(
        @SerializedName("base_stat")
        var baseStat: String,
        var stat: Stat
)

data class Type(
        var name: String
)

data class Stat(
        var name: String
)

data class PokemonImage(
        @SerializedName("front_default")
        var image: String

)