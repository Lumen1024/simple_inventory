package com.lumen1024.simpleinventory.presentation.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
        composable<Screen.ItemsList> { }
        composable<Screen.ModifyItem> { }
        composable<Screen.Settings> { }
    }
}