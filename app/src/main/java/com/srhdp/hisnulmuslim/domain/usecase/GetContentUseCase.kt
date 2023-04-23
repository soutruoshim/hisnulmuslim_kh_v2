package com.srhdp.hisnulmuslim.domain.usecase

import com.srhdp.hisnulmuslim.data.model.Content
import com.srhdp.hisnulmuslim.domain.repository.DomainRepository
import kotlinx.coroutines.flow.Flow

class GetContentUseCase(private val domainRepository: DomainRepository) {
    fun execute(): Flow<List<Content>> {
        return domainRepository.getContents()
    }
}