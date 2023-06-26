package com.example.rickandmorty

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        val request =   NetworkLayer.apiClient.getCharacterById(characterId)  //calling suspend function

        //some error we cant handle
        if(request.failed) {
            return null
        }


        //if we cant receive data or sth in our programm
        if (!request.isSuccessful) {
            return null
        }
        return request.body  //if successfull data fetch

    }
}