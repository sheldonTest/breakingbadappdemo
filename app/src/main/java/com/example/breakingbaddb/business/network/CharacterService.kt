package com.example.breakingbaddb.business.network

import com.example.breakingbaddb.business.domain.model.Characters
import com.example.breakingbaddb.business.network.model.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("characters")
    suspend fun getCharacters() : List<CharacterDto>

    @GET("characters")
    suspend fun searchByName(@Query("name")name: String) : List<CharacterDto>

    @GET("characters")
    suspend fun searchBySeasonAppearance(@Query("appearance")seasons: List<Int>): List<CharacterDto>

}