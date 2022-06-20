package com.example.kotlin1homework3.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlin1homework3.model.CharacterModel

@Dao
interface CharacterDao {

    @androidx.room.Query("SELECT * FROM character")
    fun getAll(): List<CharacterModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<CharacterModel>)
}