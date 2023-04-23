package com.srhdp.hisnulmuslim.presentation.di

import com.srhdp.hisnulmuslim.domain.repository.DomainRepository
import com.srhdp.hisnulmuslim.domain.usecase.GetContentUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetContentUseCase(
        domainRepository: DomainRepository
    ):GetContentUseCase {
        return GetContentUseCase(domainRepository)
    }
}