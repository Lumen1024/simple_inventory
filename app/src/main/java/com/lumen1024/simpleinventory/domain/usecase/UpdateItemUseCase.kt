package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.dao.InventoryItemDao
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import javax.inject.Inject

class UpdateItemUseCase @Inject constructor(
    private val inventoryItemDao: InventoryItemDao
) {
    suspend operator fun invoke(item: InventoryItem) {
        inventoryItemDao.updateItem(item)
    }
}