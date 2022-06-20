package com.example.kotlin1homework3.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
data class CharacterModel(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("status")
    var status: String,

    @SerializedName("origin")
    var origin: Source
)
