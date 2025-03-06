package com.lumen1024.simpleinventory.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import kotlinx.coroutines.flow.Flow

@Dao
interface FolderDao {
    @Query("SELECT * FROM inventoryfolder")
    fun getAll(): Flow<List<InventoryFolder>>

    @Query("SELECT * FROM inventoryfolder WHERE id = :id")
    fun getById(id: Long): Flow<InventoryFolder?>

    @Insert
    suspend fun addPlace(inventoryFolder: InventoryFolder)

    @Query("DELETE FROM inventoryfolder WHERE id = :id")
    suspend fun removePlace(id: Long)

    @Update
    suspend fun updatePlace(inventoryFolder: InventoryFolder)

}