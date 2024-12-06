package com.lumen1024.simpleinventory.presentation.screen.items_list.model

import androidx.compose.runtime.Immutable
import com.lumen1024.simpleinventory.domain.entity.InventoryItem

@Immutable
sealed interface ItemsListUiAction {
    object OnButtonClicked : ItemsListUiAction
    data class OnSearchQueryChanged(val query: String) : ItemsListUiAction
    data class OnItemClicked(val item: InventoryItem) : ItemsListUiAction
    data class OnCounterAction(val action: CounterUiAction) : ItemsListUiAction
}