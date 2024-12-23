package com.lumen1024.simpleinventory.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    object Places : Screen
    @Serializable
    object Items : Screen
    @Serializable
    object ModifyItem : Screen
    @Serializable
    object Settings : Screen
}

fun Screen.getIcon() = when (this) {
    Screen.Items -> Icons.AutoMirrored.Filled.List
    Screen.ModifyItem -> Icons.Default.Add
    Screen.Settings -> Icons.Default.Settings
    else -> throw IllegalArgumentException("Screen $this has no icon")
}

fun Screen.getTitle() = when (this) {
    Screen.Items -> "Items"
    Screen.ModifyItem -> "Edit Item"
    Screen.Settings -> "Settings"
    else -> throw IllegalArgumentException("Screen $this has no title")

}