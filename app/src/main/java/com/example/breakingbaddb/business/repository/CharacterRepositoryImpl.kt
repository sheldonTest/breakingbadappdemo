package com.example.breakingbaddb.business.repository

import com.example.breakingbaddb.business.domain.model.CharacterDtoMapper
import com.example.breakingbaddb.business.domain.model.Characters
import com.example.breakingbaddb.business.network.CharacterService

class CharacterRepositoryImpl(
    private val service: CharacterService,
    private val mapper: CharacterDtoMapper
) : CharacterRepository {

    override suspend fun getCharacters(): List<Characters> {
        return mapper.toDomainList(service.getCharacters())
    }

    override suspend fun searchByName(name: String): List<Characters> {
        return mapper.toDomainList(service.searchByName(name))
    }

    override suspend fun searchBySeasonAppearance(seasons: List<Int>): List<Characters> {
        return mapper.toDomainList(service.searchBySeasonAppearance(seasons))
    }


}