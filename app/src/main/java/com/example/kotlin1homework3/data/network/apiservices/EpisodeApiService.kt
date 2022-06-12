package com.example.kotlin1homework3.data.network.apiservices

import com.example.kotlin1homework3.model.CharacterModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.model.EpisodeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisodes(): Call<RickyMortyResponse<EpisodeModel>>

    @GET("api/episode/{id}")
    fun fetchSingleEpisode(
        @Path("id") id: Int): Call<EpisodeModel>
}