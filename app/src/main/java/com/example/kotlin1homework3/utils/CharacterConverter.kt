package com.example.kotlin1homework3.utils

import androidx.room.TypeConverter

class CharacterConverter {

    @TypeConverter
    fun fromLocation(source : com.example.kotlin1homework3.model.Source): String{
        return source.name
    }

    @TypeConverter
    fun dateToTimestamp(name: String): com.example.kotlin1homework3.model.Source {
        return com.example.kotlin1homework3.model.Source(name, name)
    }
}