package com.example.breakingbaddb.business.domain.util

interface DomainMapper<T,DomainModel> {

    fun mapToDomainModel(entity: T) : DomainModel
}
