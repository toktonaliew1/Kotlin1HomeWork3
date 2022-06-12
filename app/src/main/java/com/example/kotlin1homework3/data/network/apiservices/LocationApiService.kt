package com.example.kotlin1homework3.data.network.apiservices

import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.model.LocationModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {

    @GET("api/location")
    fun fetchLocations(): Call<RickyMortyResponse<LocationModel>>

    @GET("api/location/{id}")
    fun fetchSingleLocation(
        @Path("id") id: Int): Call<LocationModel>
}