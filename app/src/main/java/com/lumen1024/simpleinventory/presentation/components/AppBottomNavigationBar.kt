package com.lumen1024.simpleinventory.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
            icon = { Icon(Icons.AutoMirrored.Filled.List, "Items") },
        )
        NavigationBarItem(
            selected = (currentScreen == Screen.ModifyItem),
            onClick = { onNavigate(Screen.ModifyItem) },
            icon = { Icon(Icons.Default.Add, "Add Item") },
        )
        NavigationBarItem(
            selected = (currentScreen == Screen.Settings),
            onClick = { onNavigate(Screen.Settings) },
            icon = { Icon(Icons.Default.Settings, "Settings") },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomNavigationBarPreview() {
    AppBottomNavigationBar(
        currentScreen = Screen.ItemsList,
        onNavigate = {},
    )
}