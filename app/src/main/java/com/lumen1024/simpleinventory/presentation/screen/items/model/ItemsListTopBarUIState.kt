package com.lumen1024.simpleinventory.presentation.screen.items.model

import com.lumen1024.simpleinventory.domain.entity.InventoryItem

data class ItemsListTopBarUIState(
    val query: String = "",
    val foundedItems: List<InventoryItem> = emptyList(),
)