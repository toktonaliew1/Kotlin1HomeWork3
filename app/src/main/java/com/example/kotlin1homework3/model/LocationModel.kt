package com.example.kotlin1homework3.model

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("dimension")
    var dimension: String
)