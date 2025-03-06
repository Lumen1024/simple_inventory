package com.lumen1024.simpleinventory.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lumen1024.simpleinventory.presentation.screen.items.ui.ItemsScreen
import com.lumen1024.simpleinventory.presentation.screen.folders.ui.FoldersScreen

@Composable
fun MainNavGraph(
    modifier: Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Folders
    ) {
        composable<Screen.Folders> { FoldersScreen() }
        composable<Screen.Items> { ItemsScreen() }
//        composable<Screen.Item> { }
//        composable<Screen.Settings> { }
    }
}