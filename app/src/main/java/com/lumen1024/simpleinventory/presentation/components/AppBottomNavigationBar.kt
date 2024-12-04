package com.lumen1024.simpleinventory.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lumen1024.simpleinventory.presentation.core.Screen

@Composable
fun AppBottomNavigationBar(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = (currentScreen == Screen.ItemsList),
            onClick = { onNavigate(Screen.ItemsList) },
            icon = { Icons.AutoMirrored.Filled.List },
        )
        NavigationBarItem(
            selected = (currentScreen == Screen.ModifyItem),
            onClick = { onNavigate(Screen.ModifyItem) },
            icon = { Icons.Default.Add },
        )
        NavigationBarItem(
            selected = (currentScreen == Screen.Settings),
            onClick = { onNavigate(Screen.Settings) },
            icon = { Icons.Default.Settings },
        )
    }
}