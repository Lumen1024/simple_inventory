package com.lumen1024.simpleinventory.data.repository

import com.lumen1024.simpleinventory.data.dao.PlaceDao
import com.lumen1024.simpleinventory.domain.entity.InventoryPlace
import com.lumen1024.simpleinventory.domain.repository.PlaceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalPlaceRepository @Inject constructor(
    private val placeDao: PlaceDao
) : PlaceRepository {
    override fun getPlace(id: String): Flow<InventoryPlace?> = placeDao.getById(id)

    override fun getPlaces(): Flow<List<InventoryPlace>> = placeDao.getAll()

    override suspend fun addPlace(place: InventoryPlace) = placeDao.addPlace(place)

    override suspend fun removePlaceById(id: String) = placeDao.removePlace(id)

    override suspend fun updatePlace(place: InventoryPlace) = placeDao.updatePlace(place)
}