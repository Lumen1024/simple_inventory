package com.lumen1024.simpleinventory.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    object Folders : Screen
    @Serializable
    data class Items(val folderId: Long) : Screen
    @Serializable
    object Item : Screen
    @Serializable
    object Settings : Screen
}

fun Screen.getTitle() = when (this) {
    Screen.Folders -> {
        "Folders"
    }
    is Screen.Items -> {
        "Items"
    }
    Screen.Item -> {
        "Item"
    }
    Screen.Settings -> {
        "Settings"
    }
    else -> {
        throw IllegalArgumentException("Screen $this has no title")
    }
}