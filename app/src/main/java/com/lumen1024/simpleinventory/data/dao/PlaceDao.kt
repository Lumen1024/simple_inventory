package com.lumen1024.simpleinventory.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lumen1024.simpleinventory.domain.entity.InventoryPlace
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceDao {
    @Query("SELECT * FROM inventoryplace")
    fun getAll(): Flow<List<InventoryPlace>>

    @Query("SELECT * FROM inventoryplace WHERE id = :id")
    fun getById(id: String): Flow<InventoryPlace?>

    @Insert
    suspend fun addPlace(inventoryPlace: InventoryPlace)

    @Query("DELETE FROM inventoryplace WHERE id = :id")
    suspend fun removePlace(id: String)

    @Update
    suspend fun updatePlace(inventoryPlace: InventoryPlace)

}