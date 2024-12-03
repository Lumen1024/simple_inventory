package com.lumen1024.simpleinventory.presentation.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavGraph(modifier: Modifier) {
    val navHostController = rememberNavController()
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