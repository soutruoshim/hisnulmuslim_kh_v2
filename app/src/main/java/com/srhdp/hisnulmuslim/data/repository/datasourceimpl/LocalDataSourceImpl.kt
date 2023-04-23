package com.srhdp.hisnulmuslim.data.repository.datasourceimpl

import com.srhdp.hisnulmuslim.data.db.ContentDao
import com.srhdp.hisnulmuslim.data.model.Content
import com.srhdp.hisnulmuslim.data.repository.datasource.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    private val contentDao: ContentDao
):LocalDataSource {

    override fun getContents(): Flow<List<Content>> {
       return contentDao.getAllContent()
    }

    override fun searchContents(query: String): Flow<List<Content>> {
        return contentDao.searchContent(query)
    }
}