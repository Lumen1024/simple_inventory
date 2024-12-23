package com.lumen1024.simpleinventory.presentation.screen.items.model

sealed interface ItemsListTopBarAction {
    data class OnSearchQueryChanged(val query: String) : ItemsListTopBarAction
    object OnSearchClicked : ItemsListTopBarAction
}