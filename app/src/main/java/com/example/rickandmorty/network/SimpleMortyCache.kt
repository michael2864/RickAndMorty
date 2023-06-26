package com.dmp.rickandmorty.network

import com.dmp.rickandmorty.domain.models.Character

object SimpleMortyCache {

    val characterMap = mutableMapOf<Int, Character>()
}