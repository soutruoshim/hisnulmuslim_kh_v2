package com.srhdp.hisnulmuslim.presentation.di

import android.app.Application
import androidx.room.Room
import com.srhdp.hisnulmuslim.data.db.ContentDao
import com.srhdp.hisnulmuslim.data.db.HisnulMuslimDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application): HisnulMuslimDB {
        return Room.databaseBuilder(app, HisnulMuslimDB::class.java, "hisn_db")
            .createFromAsset("databases/hisn.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideContentDao(hisnulMuslimDB: HisnulMuslimDB): ContentDao {
        return hisnulMuslimDB.getContentDao()
    }

}