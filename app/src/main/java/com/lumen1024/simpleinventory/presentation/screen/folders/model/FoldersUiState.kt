package com.lumen1024.simpleinventory.presentation.screen.folders.model

import androidx.compose.runtime.Immutable
import com.lumen1024.simpleinventory.domain.entity.InventoryFolder

@Immutable
data class FoldersUiState(
    val folders: List<InventoryFolder> = emptyList(),
)
