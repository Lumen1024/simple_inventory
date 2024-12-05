package com.lumen1024.simpleinventory.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryItemDao {
    @Query("SELECT * FROM inventoryitem")
    fun getAll(): Flow<List<InventoryItem>>

    @Query("SELECT * FROM inventoryitem WHERE name = :name")
    fun getByName(name: String): Flow<List<InventoryItem>>

    @Query("SELECT * FROM inventoryitem WHERE id = :id")
    fun getById(id: String): Flow<InventoryItem?>

    @Insert
    suspend fun addItem(vararg item: InventoryItem)

    @Query("DELETE FROM inventoryitem WHERE id = :id")
    suspend fun removeItemById(id: String)

    @Update
    suspend fun updateItem(item: InventoryItem)

}