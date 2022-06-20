package com.example.kotlin1homework3.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlin1homework3.model.CharacterModel
import com.example.kotlin1homework3.repository.CharacterRepository

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun getCharacters(): ArrayList<CharacterModel>{
        return repository.getCharacters()
    }

    fun fetchCharacterId(id : Int): MutableLiveData<CharacterModel>{
        return repository.fetchCharacterId(id)
    }

    fun fetchCharacters(): LiveData<PagingData<CharacterModel>>{
        return repository.fetchCharacters().cachedIn(viewModelScope)
    }
}