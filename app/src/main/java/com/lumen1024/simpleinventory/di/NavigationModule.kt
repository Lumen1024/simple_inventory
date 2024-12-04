package com.lumen1024.simpleinventory.di

import com.lumen1024.simpleinventory.presentation.lib.navigation.ChannelNavigator
import com.lumen1024.simpleinventory.presentation.lib.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = ChannelNavigator()
}