package com.lumen1024.simpleinventory.data.repository

import com.lumen1024.simpleinventory.data.dao.FolderDao
import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import com.lumen1024.simpleinventory.domain.repository.FolderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalFolderRepository @Inject constructor(
    private val folderDao: FolderDao
) : FolderRepository {
    override fun getFolder(id: Long): Flow<InventoryFolder?> = folderDao.getById(id)

    override fun getFolders(): Flow<List<InventoryFolder>> = folderDao.getAll()

    override suspend fun addFolder(folder: InventoryFolder) = folderDao.addPlace(folder)

    override suspend fun removeFolder(id: Long) = folderDao.removePlace(id)

    override suspend fun updateFolder(folder: InventoryFolder) = folderDao.updatePlace(folder)
}