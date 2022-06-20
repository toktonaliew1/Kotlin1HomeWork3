package com.example.kotlin1homework3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.*
import com.example.kotlin1homework3.App
import com.example.kotlin1homework3.model.CharacterModel
import com.example.kotlin1homework3.model.RickyMortyResponse
import com.example.kotlin1homework3.repository.pagingsource.CharacterPagingSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    val data: MutableLiveData<RickyMortyResponse<CharacterModel>> = MutableLiveData()

    fun getCharacters(): ArrayList<CharacterModel> {
        val list: ArrayList<CharacterModel> = ArrayList()
        App.characterDao?.let { list.addAll(it.getAll()) }
        return list
    }

    fun fetchCharacters(): LiveData<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSource(App.characterApiService!!)
            }, initialKey = 1
        ).liveData
    }

    fun fetchCharacterId(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
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