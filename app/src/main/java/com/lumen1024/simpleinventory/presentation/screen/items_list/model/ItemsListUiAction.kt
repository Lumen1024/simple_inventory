package com.lumen1024.simpleinventory.presentation.screen.items_list.model

sealed interface ItemsListUiAction {
    object OnButtonClicked : ItemsListUiAction
}