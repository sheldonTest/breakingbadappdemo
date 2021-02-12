package com.example.breakingbaddb.business.di

import com.example.breakingbaddb.business.domain.model.CharacterDtoMapper
import com.example.breakingbaddb.business.network.CharacterService
import com.example.breakingbaddb.business.repository.CharacterRepository
import com.example.breakingbaddb.business.repository.CharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(service: CharacterService,dtoMapper: CharacterDtoMapper) : CharacterRepository {
        return CharacterRepositoryImpl(service,dtoMapper)
    }

}