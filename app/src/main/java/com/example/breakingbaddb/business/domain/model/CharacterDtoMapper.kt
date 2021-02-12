package com.example.breakingbaddb.business.domain.model

import com.example.breakingbaddb.business.domain.util.DomainMapper
import com.example.breakingbaddb.business.network.model.CharacterDto

class CharacterDtoMapper : DomainMapper<CharacterDto,Characters> {

    override fun mapToDomainModel(entity: CharacterDto): Characters {

        return Characters(
            appearance = entity.appearance,
            birthday = entity.birthday,
            category = entity.category,
            char_id = entity.char_id,
            img = entity.img,
            name = entity.name,
            nickname = entity.nickname,
            occupation = entity.occupation,
            portrayed = entity.portrayed,
            status =  entity.status )
    }

    fun toDomainList(entityList: List<CharacterDto>) : List<Characters> {
        return entityList.map { mapToDomainModel(it) }
    }

}