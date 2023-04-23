package com.srhdp.hisnulmuslim.presentation.di

import android.app.Application
import com.srhdp.hisnulmuslim.domain.usecase.GetContentUseCase
import com.srhdp.hisnulmuslim.domain.usecase.GetSearchContentUseCase
import com.srhdp.hisnulmuslim.presentation.viewmodel.DataViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getContentUseCase: GetContentUseCase,
        getSearchContentUseCase: GetSearchContentUseCase
    ): DataViewModelFactory {
        return DataViewModelFactory(
            application,
            getContentUseCase,
            getSearchContentUseCase
        )
    }
}