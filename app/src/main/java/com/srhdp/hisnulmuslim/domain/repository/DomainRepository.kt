package com.srhdp.hisnulmuslim.domain.repository

import com.srhdp.hisnulmuslim.data.model.Content
import kotlinx.coroutines.flow.Flow

interface DomainRepository {
    fun getContents(): Flow<List<Content>>
    fun getSearchContents(query:String):Flow<List<Content>>
}