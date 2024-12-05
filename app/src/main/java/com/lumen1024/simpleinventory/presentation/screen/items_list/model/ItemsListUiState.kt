package com.lumen1024.simpleinventory.presentation.screen.items_list.model

import androidx.compose.runtime.Immutable
import com.lumen1024.simpleinventory.domain.entity.InventoryItem

@Immutable
data class ItemsListUiState(
    val items: List<InventoryItem> = emptyList(),
)