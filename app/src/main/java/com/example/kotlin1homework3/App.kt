package com.example.kotlin1homework3

import android.app.Application
import com.example.kotlin1homework3.network.RetrofitClient
import com.example.kotlin1homework3.network.apiservices.CharacterApiService

class App :Application() {

    companion object {
        var characterApiService:CharacterApiService? = null
    }

    private val retrofitClient = RetrofitClient()

    override fun onCreate() {
        super.onCreate()
        characterApiService = retrofitClient.providerApiService()
    }
}