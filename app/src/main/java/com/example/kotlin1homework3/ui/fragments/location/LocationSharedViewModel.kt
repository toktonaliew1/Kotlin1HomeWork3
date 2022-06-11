package com.example.kotlin1homework3.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.model.LocationModel
import com.example.kotlin1homework3.repository.LocationRepository

class LocationSharedViewModel : ViewModel() {

    private val repository = LocationRepository()

    fun fetchLocationId(id : Int): MutableLiveData<LocationModel> {
        return repository.fetchLocationId(id)
    }

    fun fetchLocation(): MutableLiveData<RickyMortyResponse<LocationModel>> {
        return repository.fetchLocations()
    }
}