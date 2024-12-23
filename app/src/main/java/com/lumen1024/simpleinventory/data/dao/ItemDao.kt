package com.lumen1024.simpleinventory.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.entity.InventoryPlace
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM inventoryitem")
    fun getAll(): Flow<List<InventoryItem>>

    @Query("SELECT * FROM inventoryitem WHERE id = :id")
    fun getById(id: String): Flow<InventoryItem?>

    @Query("SELECT * FROM inventoryitem WHERE placeId = :placeId")
    fun getItemsByPlace(placeId: Long): Flow<List<InventoryItem>>

    @Insert
    suspend fun addItem(vararg item: InventoryItem)

    @Query("DELETE FROM inventoryitem WHERE id = :id")
    suspend fun removeItem(id: String)

    @Update
    suspend fun updateItem(item: InventoryItem)

}