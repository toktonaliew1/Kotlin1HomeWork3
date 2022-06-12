package com.example.kotlin1homework3.data.network

import com.example.kotlin1homework3.data.network.apiservices.CharacterApiService
import com.example.kotlin1homework3.data.network.apiservices.EpisodeApiService
import com.example.kotlin1homework3.data.network.apiservices.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    fun providerCharacterApiService(): CharacterApiService {
        return retrofit.create(CharacterApiService::class.java)
    }

    fun providerEpisodeApiService(): EpisodeApiService {
        return retrofit.create(EpisodeApiService::class.java)
    }

    fun providerLocationApiService(): LocationApiService {
        return retrofit.create(LocationApiService::class.java)
    }
}