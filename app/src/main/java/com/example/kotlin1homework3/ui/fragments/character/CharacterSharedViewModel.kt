package com.example.kotlin1homework3.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.model.CharacterModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.repository.CharacterRepository

class CharacterSharedViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun fetchCharacterId(id : Int): MutableLiveData<CharacterModel>{
        return repository.fetchCharacterId(id)
    }

    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>>{
        return repository.fetchCharacters()
    }
}