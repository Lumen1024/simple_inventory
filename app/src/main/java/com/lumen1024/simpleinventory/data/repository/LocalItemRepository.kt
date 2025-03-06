package com.lumen1024.simpleinventory.data.repository

import com.lumen1024.simpleinventory.data.dao.ItemDao
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalItemRepository @Inject constructor(
    private val itemDao: ItemDao
) : ItemRepository {
    override fun getItem(id: Long): Flow<InventoryItem?> = itemDao.getById(id)

    override fun getItemsByPlace(placeid: Long): Flow<List<InventoryItem>> =
        itemDao.getItemsByPlace(placeid)


    override suspend fun addItem(item: InventoryItem) = itemDao.addItem(item)

    override suspend fun removeItem(id: Long) = itemDao.removeItem(id)

    override suspend fun updateItem(item: InventoryItem) = itemDao.updateItem(item)
}