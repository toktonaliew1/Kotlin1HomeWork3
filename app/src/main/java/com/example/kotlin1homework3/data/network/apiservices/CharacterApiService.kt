package com.example.kotlin1homework3.data.network.apiservices

import com.example.kotlin1homework3.model.CharacterModel
import retrofit2.Call
import com.example.kotlin1homework3.model.RickyMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int
    ): RickyMortyResponse<CharacterModel>?

    @GET("api/character/{id}")
    fun fetchSingleCharacter(
        @Path("id") id: Int
    ): Call<CharacterModel>
}