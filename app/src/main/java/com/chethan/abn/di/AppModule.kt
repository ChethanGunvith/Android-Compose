package com.chethan.abn.di

import android.app.Application
import androidx.room.Room
import com.chethan.abn.API_REST_URL
import com.chethan.abn.api.NetWorkApi
import com.chethan.abn.db.AppDatabase
import com.chethan.abn.db.VenueDao
import com.chethan.abn.db.VenueDetailsDao
import com.chethan.demoproject.utils.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideGithubService(): NetWorkApi {
        val retrofit =
                Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(LiveDataCallAdapterFactory())
                        .baseUrl(API_REST_URL)
                        .build()
        return retrofit.create(NetWorkApi::class.java)
    }

}
