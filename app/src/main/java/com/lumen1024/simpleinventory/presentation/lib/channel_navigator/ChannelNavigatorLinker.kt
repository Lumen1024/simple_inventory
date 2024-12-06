package com.lumen1024.simpleinventory.presentation.lib.channel_navigator

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun ChannelNavigatorLinker(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)

    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) return@collect

            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }
                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route, intent.builder)
                }
            }
        }
    }
}