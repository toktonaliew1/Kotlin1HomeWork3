package com.example.kotlin1homework3.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework3.App
import com.example.kotlin1homework3.model.CharacterModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterSharedViewModel : ViewModel() {

    val data : MutableLiveData<RickyMortyResponse<CharacterModel>> = MutableLiveData()

    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>> {
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
        return data
    }

    fun fetchCharacterId(id : Int): MutableLiveData<CharacterModel>{
        val data:MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiService?.fetchSingleCharacter(id)?.enqueue(object :
            Callback<CharacterModel> {
            override fun onResponse(
                call: Call<CharacterModel>,
                response: Response<CharacterModel>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}