package com.lumen1024.simpleinventory.presentation.screen.folders.model

import com.lumen1024.simpleinventory.domain.entity.InventoryFolder

sealed interface FoldersUiAction {
    data class OnFolderClicked(val folder: InventoryFolder) : FoldersUiAction
}
