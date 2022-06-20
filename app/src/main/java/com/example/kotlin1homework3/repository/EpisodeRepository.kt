package com.example.kotlin1homework3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kotlin1homework3.App
import com.example.kotlin1homework3.model.EpisodeModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.repository.pagingsource.EpisodePagingSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    val data: MutableLiveData<RickyMortyResponse<EpisodeModel>> = MutableLiveData()

    fun fetchEpisodes(): LiveData<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                EpisodePagingSource(App.episodeApiService!!)
            }, initialKey = 1
        ).liveData
    }

    fun getEpisodes(): ArrayList<EpisodeModel> {
        val list: ArrayList<EpisodeModel> = ArrayList()
        App.episodeDao?.let { list.addAll(it.getAll()) }
        return list
    }

    fun fetchEpisodeId(id: Int): MutableLiveData<EpisodeModel> {
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