package com.example.kotlin1homework3.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlin1homework3.App
import com.example.kotlin1homework3.model.LocationModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    val data: MutableLiveData<RickyMortyResponse<LocationModel>> = MutableLiveData()

    fun fetchLocations(): MutableLiveData<RickyMortyResponse<LocationModel>> {
        App.locationApiService?.fetchLocations()
            ?.enqueue(object : Callback<RickyMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickyMortyResponse<LocationModel>>,
                    response: Response<RickyMortyResponse<LocationModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickyMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
    fun fetchLocationId(id : Int): MutableLiveData<LocationModel> {
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