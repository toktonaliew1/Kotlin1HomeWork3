package com.example.kotlin1homework3.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlin1homework3.model.LocationModel

@Dao
interface LocationDao {

    @androidx.room.Query("SELECT * FROM location")
    fun getAll(): List<LocationModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<LocationModel>)
}