package com.example.kotlin1homework3.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlin1homework3.model.LocationModel
import com.example.kotlin1homework3.repository.LocationRepository

class LocationViewModel : ViewModel() {

    private val repository = LocationRepository()

    fun fetchLocationId(id : Int): MutableLiveData<LocationModel> {
        return repository.fetchLocationId(id)
    }

    fun fetchLocations(): LiveData<PagingData<LocationModel>>{
        return repository.fetchLocations().cachedIn(viewModelScope)
    }

    fun getLocations(): ArrayList<LocationModel>{
        return repository.getLocations()
    }
}