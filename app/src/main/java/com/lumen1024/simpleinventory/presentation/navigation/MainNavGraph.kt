package com.lumen1024.simpleinventory.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lumen1024.simpleinventory.presentation.screen.items_list.ui.ItemsListScreen

@Composable
fun MainNavGraph(
    modifier: Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.ItemsList
    ) {
        composable<Screen.ItemsList> { ItemsListScreen() }
        composable<Screen.ModifyItem> { }
        composable<Screen.Settings> { }
    }
}