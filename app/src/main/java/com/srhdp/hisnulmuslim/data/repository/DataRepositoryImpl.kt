package com.srhdp.hisnulmuslim.data.repository

import com.srhdp.hisnulmuslim.data.model.Content
import com.srhdp.hisnulmuslim.data.repository.datasource.LocalDataSource
import com.srhdp.hisnulmuslim.domain.repository.DomainRepository
import kotlinx.coroutines.flow.Flow

class DataRepositoryImpl(private val localDataSource: LocalDataSource):DomainRepository {
    override fun getContents(): Flow<List<Content>> {
       return localDataSource.getContents()
    }

    override fun getSearchContents(query: String): Flow<List<Content>> {
        return localDataSource.searchContents(query)
    }
}