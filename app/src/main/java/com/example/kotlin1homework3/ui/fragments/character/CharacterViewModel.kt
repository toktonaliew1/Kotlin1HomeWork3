package com.example.kotlin1homework3.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.model.character.CharacterModel
import com.example.kotlin1homework3.repository.CharacterRepository

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>> {
        return repository.fetchCharacters()
    }

    fun fetchCharacterId(id: Int): MutableLiveData<CharacterModel> {
        return repository.fetchCharacterId(id)
    }
}