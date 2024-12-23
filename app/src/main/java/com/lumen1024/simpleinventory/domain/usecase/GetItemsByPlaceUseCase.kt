package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetItemsByPlaceUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke(placeId: Long) : Flow<List<InventoryItem>> {
        return itemRepository.getItemsByPlace(placeId)
    }
}