package com.example.kotlin1homework3.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class LocationModel(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("dimension")
    var dimension: String
)