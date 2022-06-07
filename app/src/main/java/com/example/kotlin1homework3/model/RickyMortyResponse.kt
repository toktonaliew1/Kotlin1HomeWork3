package com.example.kotlin1homework3.model

import com.google.gson.annotations.SerializedName

data class RickyMortyResponse<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    var results: ArrayList<T>
)
