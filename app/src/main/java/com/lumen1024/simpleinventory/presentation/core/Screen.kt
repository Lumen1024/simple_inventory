package com.lumen1024.simpleinventory.presentation.core

sealed interface Screen {
    @Serializable
    object ItemsList : Screen
    object ModifyItem : Screen
    object Settings : Screen
}