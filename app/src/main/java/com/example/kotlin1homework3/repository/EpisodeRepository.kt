package com.example.kotlin1homework3.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlin1homework3.App
import com.example.kotlin1homework3.model.EpisodeModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    val data: MutableLiveData<RickyMortyResponse<EpisodeModel>> = MutableLiveData()

    fun fetchEpisodes(): MutableLiveData<RickyMortyResponse<EpisodeModel>> {
        App.episodeApiService?.fetchEpisodes()
            ?.enqueue(object : Callback<RickyMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickyMortyResponse<EpisodeModel>>,
                    response: Response<RickyMortyResponse<EpisodeModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickyMortyResponse<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun fetchEpisodeId(id : Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        App.episodeApiService?.fetchSingleEpisode(id)?.enqueue(object :
            Callback<EpisodeModel> {
            override fun onResponse(
                call: Call<EpisodeModel>,
                response: Response<EpisodeModel>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<EpisodeModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}