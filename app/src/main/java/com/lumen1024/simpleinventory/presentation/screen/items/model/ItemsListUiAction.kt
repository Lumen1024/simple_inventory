package com.lumen1024.simpleinventory.presentation.screen.items.model

import androidx.compose.runtime.Immutable
import com.lumen1024.simpleinventory.domain.entity.InventoryItem

@Immutable
sealed interface ItemsListUiAction {
    data class OnItemClicked(val item: InventoryItem) : ItemsListUiAction
    data class OnCounterAction(
        val item: InventoryItem,
        val counterAction: CounterUiAction
    ) : ItemsListUiAction
}