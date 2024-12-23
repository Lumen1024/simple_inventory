package com.lumen1024.simpleinventory.di

import com.lumen1024.simpleinventory.data.repository.LocalItemRepository
import com.lumen1024.simpleinventory.data.repository.LocalPlaceRepository
import com.lumen1024.simpleinventory.domain.repository.ItemRepository
import com.lumen1024.simpleinventory.domain.repository.PlaceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindItemRepository(impl: LocalItemRepository): ItemRepository

    @Binds
    abstract fun bindPlaceRepository(impl: LocalPlaceRepository): PlaceRepository
}