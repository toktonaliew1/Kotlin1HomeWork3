package com.example.kotlin1homework3.ui.fragments.character.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.model.CharacterModel
import com.example.kotlin1homework3.repository.CharacterRepository

class CharacterDetailViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun fetchCharacterId(id : Int): MutableLiveData<CharacterModel> {
        return repository.fetchCharacterId(id)
    }
}