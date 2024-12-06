package com.lumen1024.simpleinventory.presentation.screen.items_list.model

sealed interface ItemsListTopBarAction {
    data class OnSearchQueryChanged(val query: String) : ItemsListTopBarAction
    object OnSearchClicked : ItemsListTopBarAction
}