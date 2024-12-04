package com.lumen1024.simpleinventory.domain.dao

import androidx.room.Dao
import androidx.room.Query
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryItemDao {
    @Query("SELECT * FROM inventoryitem")
    fun getAll(): Flow<List<InventoryItem>>
}