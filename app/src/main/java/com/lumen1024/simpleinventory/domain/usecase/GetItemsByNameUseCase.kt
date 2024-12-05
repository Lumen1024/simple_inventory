package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.dao.InventoryItemDao
import javax.inject.Inject

class GetItemsByNameUseCase @Inject constructor(
    private val inventoryItemDao: InventoryItemDao,
) {
    operator fun invoke(name: String) = inventoryItemDao.getByName(name)
}