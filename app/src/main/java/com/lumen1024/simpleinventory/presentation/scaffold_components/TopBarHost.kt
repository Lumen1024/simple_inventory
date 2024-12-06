package com.lumen1024.simpleinventory.presentation.scaffold_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import com.lumen1024.simpleinventory.presentation.screen.items_list.ui.ItemsListTopBar

@Composable
fun TopBarHost (
    currentScreen : Screen,
    modifier: Modifier = Modifier,
) {
    when (currentScreen) {
        Screen.ItemsList -> ItemsListTopBar()
        Screen.ModifyItem, Screen.Settings -> {
            val title = when (currentScreen) {
                Screen.ModifyItem -> "Modify Item"
                Screen.Settings -> "Settings"
                Screen.ItemsList -> TODO()
            }
        }
        else -> {}
    }
}