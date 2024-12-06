package com.lumen1024.simpleinventory.presentation.lib.channel_navigator

import androidx.navigation.NavOptionsBuilder
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import kotlinx.coroutines.channels.Channel

interface Navigator {
    val navigationChannel: Channel<NavigationIntent>
    fun navigate(
        screen: Screen,
        builder: NavOptionsBuilder.() -> Unit = { }
    )

    fun back(inclusive: Boolean = false)
    fun deepBack(screen: Screen, inclusive: Boolean = false)
}