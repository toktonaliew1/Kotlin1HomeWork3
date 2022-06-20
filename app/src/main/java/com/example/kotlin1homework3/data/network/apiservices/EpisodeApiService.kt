package com.example.kotlin1homework3.data.network.apiservices

import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.model.EpisodeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int
    ): RickyMortyResponse<EpisodeModel>?

    @GET("api/episode/{id}")
    fun fetchSingleEpisode(
        @Path("id") id: Int
    ): Call<EpisodeModel>
}