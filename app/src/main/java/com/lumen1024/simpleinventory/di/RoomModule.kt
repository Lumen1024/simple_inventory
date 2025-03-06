package com.lumen1024.simpleinventory.di

import android.content.Context
import androidx.room.Room
import com.lumen1024.simpleinventory.data.AppDatabase
import com.lumen1024.simpleinventory.data.dao.ItemDao
import com.lumen1024.simpleinventory.data.dao.FolderDao
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
    fun provideItemDao(database: AppDatabase): ItemDao = database.itemDao()

    @Provides
    @Singleton
    fun providePlaceDao(database: AppDatabase): FolderDao = database.folderDao()

}