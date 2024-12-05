package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.dao.InventoryItemDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetItemsUseCase @Inject constructor(
    private val inventoryItemDao: InventoryItemDao
) {
    operator fun invoke() : Flow<List<InventoryItem>> = inventoryItemDao.getAll()
}