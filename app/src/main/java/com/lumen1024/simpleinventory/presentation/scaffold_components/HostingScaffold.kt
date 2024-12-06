package com.lumen1024.simpleinventory.presentation.scaffold_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.lumen1024.simpleinventory.presentation.lib.channel_navigator.ChannelNavigatorLinker
import com.lumen1024.simpleinventory.presentation.navigation.MainNavGraph
import com.lumen1024.simpleinventory.presentation.navigation.NavigationViewModel
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import com.lumen1024.simpleinventory.presentation.utils.getCurrentScreenAsState

@Composable
fun HostingScaffold() {
    val viewModel: NavigationViewModel = hiltViewModel()
    val navHostController = rememberNavController()
    ChannelNavigatorLinker(viewModel.navigationChannel, navHostController)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                TopBarHost(
                    currentScreen = navHostController.getCurrentScreenAsState().value
                        ?: Screen.ItemsList,
                )
            }
        },
        bottomBar = {
            BottomBarHost(
                currentScreen = navHostController.getCurrentScreenAsState().value
                    ?: Screen.ItemsList
            )
        }
    ) { innerPadding ->
        MainNavGraph(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), navHostController
        )
    }
}