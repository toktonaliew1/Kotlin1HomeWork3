package com.example.kotlin1homework3.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlin1homework3.model.EpisodeModel
import com.example.kotlin1homework3.repository.EpisodeRepository

class EpisodeViewModel : ViewModel() {

    private val repository = EpisodeRepository()

    fun fetchEpisodeId(id: Int): MutableLiveData<EpisodeModel> {
        return repository.fetchEpisodeId(id)
    }

    fun fetchEpisodes(): LiveData<PagingData<EpisodeModel>> {
        return repository.fetchEpisodes().cachedIn(viewModelScope)
    }

    fun getEpisodes(): ArrayList<EpisodeModel> {
        return repository.getEpisodes()
    }
}