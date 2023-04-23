package com.srhdp.hisnulmuslim.data.db

import androidx.room.*
import com.srhdp.hisnulmuslim.data.model.Content
import kotlinx.coroutines.flow.Flow


@Dao
interface ContentDao {

    @Query("SELECT * FROM content")
    fun getAllContent(): Flow<List<Content>>

    @Query("SELECT * FROM content WHERE name LIKE :name")
    fun searchContent(name: String): Flow<List<Content>>

}