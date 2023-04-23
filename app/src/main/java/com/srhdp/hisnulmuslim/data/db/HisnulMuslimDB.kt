package com.srhdp.hisnulmuslim.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srhdp.hisnulmuslim.data.model.Content

@Database(
    entities = [Content::class],
    version = 1,
    exportSchema = false
)
abstract class HisnulMuslimDB:RoomDatabase() {
    abstract fun getContentDao(): ContentDao
}