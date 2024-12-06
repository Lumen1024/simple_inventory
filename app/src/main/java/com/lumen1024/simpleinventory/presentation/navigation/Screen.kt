package com.lumen1024.simpleinventory.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    object ItemsList : Screen
    @Serializable
    object ModifyItem : Screen
    @Serializable
    object Settings : Screen
}

fun Screen.getIcon() = when (this) {
    Screen.ItemsList -> Icons.AutoMirrored.Filled.List
    Screen.ModifyItem -> Icons.Default.Add
    Screen.Settings -> Icons.Default.Settings
}

fun Screen.getTitle() = when (this) {
    Screen.ItemsList -> "Items"
    Screen.ModifyItem -> "Edit Item"
    Screen.Settings -> "Settings"
}