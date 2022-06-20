package com.example.kotlin1homework3.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlin1homework3.model.EpisodeModel

@Dao
interface EpisodeDao {

    @androidx.room.Query("SELECT * FROM episode")
    fun getAll(): List<EpisodeModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<EpisodeModel>)
}