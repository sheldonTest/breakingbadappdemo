package com.example.breakingbaddb.business.di

import com.example.breakingbaddb.business.domain.model.CharacterDtoMapper
import com.example.breakingbaddb.business.network.CharacterService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCharacterMapper() : CharacterDtoMapper {
        return CharacterDtoMapper()
    }

    @Singleton
    @Provides
    fun provideCharacterService() : CharacterService {
        return Retrofit.Builder()
            .baseUrl("https://www.breakingbadapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CharacterService::class.java)
    }

}