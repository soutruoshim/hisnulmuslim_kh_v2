package com.srhdp.hisnulmuslim.presentation.di

import com.srhdp.hisnulmuslim.presentation.adapter.ContentAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideContentAdapter(): ContentAdapter {
        return ContentAdapter()
    }
}