package com.example.kotlin1homework3.ui.fragments.episode


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.model.EpisodeModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.repository.EpisodeRepository


class EpisodeSharedViewModel : ViewModel() {

    private val repository = EpisodeRepository()

    fun fetchEpisodeId(id : Int): MutableLiveData<EpisodeModel> {
        return repository.fetchEpisodeId(id)
    }

    fun fetchEpisodes(): MutableLiveData<RickyMortyResponse<EpisodeModel>> {
        return repository.fetchEpisodes()
    }
}