package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.entity.InventoryPlace
import com.lumen1024.simpleinventory.domain.repository.PlaceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlacesUseCase @Inject constructor(
    private val placeRepository: PlaceRepository
) {

    operator fun invoke(): Flow<List<InventoryPlace>> {
        return placeRepository.getPlaces()
    }

}