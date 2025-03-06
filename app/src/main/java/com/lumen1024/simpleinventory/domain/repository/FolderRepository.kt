package com.lumen1024.simpleinventory.domain.repository

import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import kotlinx.coroutines.flow.Flow

interface FolderRepository {
    fun getFolder(id: Long): Flow<InventoryFolder?>
    fun getFolders(): Flow<List<InventoryFolder>>

    suspend fun addFolder(folder: InventoryFolder)
    suspend fun removeFolder(id: Long)
    suspend fun updateFolder(folder: InventoryFolder)
}