package com.example.kotlin1homework3.model.character

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("id") var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("status")
    var status: String,

    )