package com.lumen1024.simpleinventory.domain.repository

import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.entity.InventoryPlace
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItem(id: String): Flow<InventoryItem?>
    fun getItems(): Flow<List<InventoryItem>>
    fun getItemsByPlace(place: InventoryPlace): Flow<List<InventoryItem>>

    suspend fun addItem(item: InventoryItem)
    suspend fun removeItem(id: String)
    suspend fun updateItem(item: InventoryItem)
}