package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.data.dao.ItemDao
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor(
    private val inventoryItemDao: ItemDao,
) {
    operator fun invoke(id: String) = inventoryItemDao.getById(id)
}