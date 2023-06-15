package com.example.rickandmorty

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        val request =   NetworkLayer.apiClient.getCharacterById(characterId)  //calling suspend function
        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }
}