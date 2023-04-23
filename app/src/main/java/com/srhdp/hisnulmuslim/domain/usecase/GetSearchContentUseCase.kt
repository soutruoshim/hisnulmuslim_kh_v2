package com.srhdp.hisnulmuslim.domain.usecase

import com.srhdp.hisnulmuslim.data.model.Content
import com.srhdp.hisnulmuslim.domain.repository.DomainRepository
import kotlinx.coroutines.flow.Flow

class GetSearchContentUseCase(private val domainRepository: DomainRepository)   {
    fun execute(query:String): Flow<List<Content>> {
        return domainRepository.getSearchContents(query)
    }
}