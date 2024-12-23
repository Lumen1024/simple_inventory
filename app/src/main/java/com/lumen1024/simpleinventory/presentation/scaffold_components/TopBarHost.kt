package com.lumen1024.simpleinventory.presentation.scaffold_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import com.lumen1024.simpleinventory.presentation.screen.items.ui.ItemsListTopBar
import com.lumen1024.simpleinventory.presentation.shared.SmallDefaultTopBar

@Composable
fun TopBarHost (
    currentScreen : Screen,
    modifier: Modifier = Modifier,
) {
    when (currentScreen) {
        Screen.Items -> ItemsListTopBar(modifier)
        Screen.ModifyItem, Screen.Settings -> {
            val title = when (currentScreen) {
                Screen.ModifyItem -> "Modify Item"
                Screen.Settings -> "Settings"
                Screen.Items -> TODO()
            }
            SmallDefaultTopBar(title = title)
        }
        else -> {}
    }
}