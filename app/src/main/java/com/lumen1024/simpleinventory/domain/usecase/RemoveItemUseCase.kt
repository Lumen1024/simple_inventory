package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.dao.InventoryItemDao
import javax.inject.Inject

class RemoveItemUseCase @Inject constructor(
    private val inventoryItemDao: InventoryItemDao
) {

    suspend operator fun invoke(id: String) {
        inventoryItemDao.removeItemById(id)
    }
}