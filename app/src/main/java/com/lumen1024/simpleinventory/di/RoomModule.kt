package com.lumen1024.simpleinventory.di

import android.content.Context
import androidx.room.Room
import com.lumen1024.simpleinventory.domain.dao.InventoryItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()


    @Provides
    @Singleton
    fun provideDao(database: AppDatabase): InventoryItemDao = database.userDao()
}