package com.example.breakingbaddb.business.repository

import com.example.breakingbaddb.business.domain.model.Characters

interface CharacterRepository {
    suspend fun getCharacters() : List<Characters>
    suspend fun searchByName(name: String) : List<Characters>
    suspend fun searchBySeasonAppearance(seasons: List<Int>) : List<Characters>
}