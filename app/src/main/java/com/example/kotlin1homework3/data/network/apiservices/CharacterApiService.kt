package com.example.kotlin1homework3.data.network.apiservices

import com.example.kotlin1homework3.model.CharacterModel
import retrofit2.Call
import com.example.kotlin1homework3.model.RickyMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): Call<RickyMortyResponse<CharacterModel>>

    @GET("api/character/{id}")
    fun fetchSingleCharacter(
        @Path("id") id: Int): Call<CharacterModel>
}