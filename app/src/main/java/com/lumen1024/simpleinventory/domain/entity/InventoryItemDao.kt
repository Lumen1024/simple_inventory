package com.lumen1024.simpleinventory.domain.entity

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryItemDao {
    @Query("SELECT * FROM inventoryitem")
    fun getAll(): Flow<List<InventoryItem>>
}