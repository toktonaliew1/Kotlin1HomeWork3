package com.example.kotlin1homework3.ui.fragments.location.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.model.LocationModel
import com.example.kotlin1homework3.repository.LocationRepository

class LocationDetailViewModel : ViewModel() {

    private val repository = LocationRepository()

    fun fetchLocationId(id : Int): MutableLiveData<LocationModel> {
        return repository.fetchLocationId(id)
    }
}