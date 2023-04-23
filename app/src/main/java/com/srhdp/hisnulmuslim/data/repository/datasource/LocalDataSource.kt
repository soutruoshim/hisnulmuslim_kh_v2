package com.srhdp.hisnulmuslim.data.repository.datasource

import com.srhdp.hisnulmuslim.data.model.Content
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
     fun getContents(): Flow<List<Content>>
     fun searchContents(query:String): Flow<List<Content>>
}