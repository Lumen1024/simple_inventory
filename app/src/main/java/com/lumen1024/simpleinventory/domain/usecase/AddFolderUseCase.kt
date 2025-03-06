package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import com.lumen1024.simpleinventory.domain.repository.FolderRepository
import javax.inject.Inject

class AddFolderUseCase @Inject constructor(
    private val folderRepository: FolderRepository,
){

    suspend operator fun invoke(folder : InventoryFolder) {
        folderRepository.addFolder(folder)
    }
}