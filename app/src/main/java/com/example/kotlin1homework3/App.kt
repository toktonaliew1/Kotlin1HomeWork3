package com.example.kotlin1homework3

import android.app.Application
import com.example.kotlin1homework3.data.network.RetrofitClient
import com.example.kotlin1homework3.data.network.apiservices.CharacterApiService
import com.example.kotlin1homework3.data.network.apiservices.EpisodeApiService
import com.example.kotlin1homework3.data.network.apiservices.LocationApiService

class App :Application() {

    companion object {
        var characterApiService:CharacterApiService? = null
        var episodeApiService:EpisodeApiService?= null
        var locationApiService : LocationApiService? = null
    }

    private val retrofitClient = RetrofitClient()

    override fun onCreate() {
        super.onCreate()
        characterApiService = retrofitClient.providerCharacterApiService()
        episodeApiService = retrofitClient.providerEpisodeApiService()
        locationApiService =retrofitClient.providerLocationApiService()
    }
}