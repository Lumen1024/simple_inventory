package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.repository.ItemRepository
import javax.inject.Inject

class UpdateItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(item: InventoryItem) {
        itemRepository.updateItem(item)
    }
}