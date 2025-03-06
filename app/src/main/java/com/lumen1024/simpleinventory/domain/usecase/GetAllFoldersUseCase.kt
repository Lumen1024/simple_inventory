package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import com.lumen1024.simpleinventory.domain.repository.FolderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFoldersUseCase @Inject constructor(
    private val folderRepository: FolderRepository
) {

    operator fun invoke(): Flow<List<InventoryFolder>> {
        return folderRepository.getFolders()
    }
}