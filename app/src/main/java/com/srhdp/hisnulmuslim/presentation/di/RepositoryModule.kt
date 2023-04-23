package com.srhdp.hisnulmuslim.presentation.di

import com.srhdp.hisnulmuslim.data.repository.DataRepositoryImpl
import com.srhdp.hisnulmuslim.data.repository.datasource.LocalDataSource
import com.srhdp.hisnulmuslim.domain.repository.DomainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        localDataSource: LocalDataSource
    ): DomainRepository {
        return DataRepositoryImpl(
            localDataSource
        )
    }

}