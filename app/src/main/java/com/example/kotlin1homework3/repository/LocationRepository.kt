package com.example.kotlin1homework3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kotlin1homework3.App
import com.example.kotlin1homework3.model.LocationModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.repository.pagingsource.LocationPagingSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    val data: MutableLiveData<RickyMortyResponse<LocationModel>> = MutableLiveData()

    fun fetchLocations(): LiveData<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                LocationPagingSource(App.locationApiService!!)
            }, initialKey = 1
        ).liveData
    }

    fun getLocations(): ArrayList<LocationModel> {
        val list: ArrayList<LocationModel> = ArrayList()
        App.locationDao?.let { list.addAll(it.getAll()) }
        return list
    }

    fun fetchLocationId(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        App.locationApiService?.fetchSingleLocation(id)?.enqueue(object :
            Callback<LocationModel> {
            override fun onResponse(
                call: Call<LocationModel>,
                response: Response<LocationModel>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<LocationModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}