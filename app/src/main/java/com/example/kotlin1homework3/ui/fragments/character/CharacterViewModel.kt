package com.example.kotlin1homework3.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.App
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.model.character.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    val data : MutableLiveData<RickyMortyResponse<CharacterModel>> = MutableLiveData()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        App.characterApiService?.fetchCharacters()
            ?.enqueue(object : Callback<RickyMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickyMortyResponse<CharacterModel>>,
                    response: Response<RickyMortyResponse<CharacterModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickyMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null

                }
            })
    }
}