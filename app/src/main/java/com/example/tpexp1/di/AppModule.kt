package com.example.tpexp1.di

import android.content.Context
import com.example.demo.repository.RepositoryImpl
import com.example.tpexp1.data.api.ApiService
import com.example.tpexp1.data.realm.RealmManager
import com.example.tpexp1.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRealmManager(
        @ApplicationContext context: Context,
    ) = RealmManager(context)

    @Singleton
    @Provides
    fun providesRepository(api: ApiService): Repository {
        return RepositoryImpl(api)
    }
}