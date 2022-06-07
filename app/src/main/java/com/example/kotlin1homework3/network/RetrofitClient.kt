package com.example.kotlin1homework3.network

import com.example.kotlin1homework3.network.apiservices.CharacterApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofitClient =
        Retrofit.Builder().baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    fun providerApiService(): CharacterApiService {
        return retrofitClient.create(CharacterApiService::class.java)
    }
}