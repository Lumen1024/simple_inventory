package com.lumen1024.simpleinventory.presentation.scaffold_components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import com.lumen1024.simpleinventory.presentation.screen.folders.ui.AddFolderDialog

@Composable
fun FloatingButtonHost(currentScreen: Screen, modifier: Modifier = Modifier) {
    if (currentScreen == Screen.Folders) {
        var dialogOpen by remember { mutableStateOf(false) }
        FloatingActionButton(onClick = { dialogOpen = true }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
        if (dialogOpen) {
            AddFolderDialog() { dialogOpen = false }
        }
    }
}