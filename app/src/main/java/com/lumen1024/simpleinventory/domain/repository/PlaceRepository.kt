package com.lumen1024.simpleinventory.domain.repository

import com.lumen1024.simpleinventory.domain.entity.InventoryPlace
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    fun getPlace(id: String): Flow<InventoryPlace?>
    fun getPlaces(): Flow<List<InventoryPlace>>

    suspend fun addPlace(place: InventoryPlace)
    suspend fun removePlaceById(id: String)
    suspend fun updatePlace(place: InventoryPlace)
}