package com.example.kotlin1homework3.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlin1homework3.data.db.daos.CharacterDao
import com.example.kotlin1homework3.data.db.daos.EpisodeDao
import com.example.kotlin1homework3.data.db.daos.LocationDao
import com.example.kotlin1homework3.model.CharacterModel
import com.example.kotlin1homework3.model.EpisodeModel
import com.example.kotlin1homework3.model.LocationModel
import com.example.kotlin1homework3.utils.CharacterConverter

@Database(
    entities = [CharacterModel::class, EpisodeModel::class, LocationModel::class],
    version = 4
)

@TypeConverters(CharacterConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun episodeDao(): EpisodeDao

    abstract fun locationDao(): LocationDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also { instance = it }

        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "character_db.db"
            ).build()
    }
}