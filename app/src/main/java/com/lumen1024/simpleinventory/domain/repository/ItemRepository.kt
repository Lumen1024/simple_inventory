package com.lumen1024.simpleinventory.domain.repository

import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItem(id: Long): Flow<InventoryItem?>
    fun getItemsByPlace(placeId: Long): Flow<List<InventoryItem>>

    suspend fun addItem(item: InventoryItem)
    suspend fun removeItem(id: Long)
    suspend fun updateItem(item: InventoryItem)
}