package com.example.rickandmorty

import retrofit2.Response

class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {
    suspend fun getCharacterById(characterId: Int): Response<GetCharacterByIdResponse> {
        return rickAndMortyService.getCharacterById(characterId)
    }
}
