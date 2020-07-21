package com.chethan.abn.di

import android.app.Application
import androidx.room.Room
import com.chethan.abn.db.AppDatabase
import com.chethan.abn.db.VenueDao
import com.chethan.abn.db.VenueDetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(ApplicationComponent::class)
class DBProviderModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "venues.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideItemsDao(db: AppDatabase): VenueDao {
        return db.venueDao()
    }


    @Singleton
    @Provides
    fun provideVenueDetailsDao(db: AppDatabase): VenueDetailsDao {
        return db.venueDetailsDao()
    }
}