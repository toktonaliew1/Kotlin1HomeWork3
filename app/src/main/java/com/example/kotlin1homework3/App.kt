package com.example.kotlin1homework3

import android.app.Application
import com.example.kotlin1homework3.data.db.RoomClient
import com.example.kotlin1homework3.data.db.daos.CharacterDao
import com.example.kotlin1homework3.data.db.daos.EpisodeDao
import com.example.kotlin1homework3.data.db.daos.LocationDao
import com.example.kotlin1homework3.data.network.RetrofitClient
import com.example.kotlin1homework3.data.network.apiservices.CharacterApiService
import com.example.kotlin1homework3.data.network.apiservices.EpisodeApiService
import com.example.kotlin1homework3.data.network.apiservices.LocationApiService

class App :Application() {

    companion object {
        var characterApiService:CharacterApiService? = null
        var characterDao: CharacterDao? = null

        var episodeApiService:EpisodeApiService?= null
        var episodeDao : EpisodeDao?= null

        var locationApiService : LocationApiService? = null
        var locationDao: LocationDao? = null
    }

    private val retrofitClient = RetrofitClient()
    private val roomClient = RoomClient()

    override fun onCreate() {
        super.onCreate()
        characterApiService = retrofitClient.providerCharacterApiService()
        characterDao = roomClient.provideCharacterDao(roomClient.provideRoom(this ))

        episodeApiService = retrofitClient.providerEpisodeApiService()
        episodeDao = roomClient.provideEpisodeDao(roomClient.provideRoom(this))

        locationApiService =retrofitClient.providerLocationApiService()
        locationDao = roomClient.provideLocationDao(roomClient.provideRoom(this))
    }
}