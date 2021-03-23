package com.example.android.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.data.commons.Constants
import com.example.android.data.models.PokemonDTO
import com.example.android.data.models.ProfileData
import com.example.android.data.utils.PokemonStatsConverter
import com.example.android.data.utils.PokemonTypeConverter

@Database(entities = [PokemonDTO::class, ProfileData::class], version = 2)
@TypeConverters(PokemonStatsConverter::class, PokemonTypeConverter::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDatabaseDao(): PokemonDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: PokemonDatabase? = null

        fun getInstance(context: Context): PokemonDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context.applicationContext).also {
                        INSTANCE = it
                    }
                }

        private fun buildDatabase(appContext: Context): PokemonDatabase {
            return Room.databaseBuilder(appContext, PokemonDatabase::class.java,
                    Constants.DATABASE_NAME
            )
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}