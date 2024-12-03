package com.lumen1024.simpleinventory.presentation.core

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    object ItemsList : Screen
    @Serializable
    object ModifyItem : Screen
    @Serializable
    object Settings : Screen
}