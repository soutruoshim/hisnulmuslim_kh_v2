package com.srhdp.hisnulmuslim.presentation.di

import com.srhdp.hisnulmuslim.data.db.ContentDao
import com.srhdp.hisnulmuslim.data.repository.datasource.LocalDataSource
import com.srhdp.hisnulmuslim.data.repository.datasourceimpl.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(contentDao: ContentDao): LocalDataSource {
        return LocalDataSourceImpl(contentDao)
    }

}