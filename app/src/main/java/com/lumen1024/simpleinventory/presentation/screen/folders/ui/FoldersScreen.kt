package com.lumen1024.simpleinventory.presentation.screen.folders.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import com.lumen1024.simpleinventory.presentation.screen.folders.model.FoldersUiAction
import com.lumen1024.simpleinventory.presentation.screen.folders.model.FoldersUiState
import com.lumen1024.simpleinventory.presentation.screen.folders.model.FoldersViewModel
import com.lumen1024.simpleinventory.presentation.utils.UiStateful


@Composable
fun FoldersScreen(
    state: FoldersUiState,
    onAction: (FoldersUiAction) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(state.folders) {
            Text(
                modifier = Modifier.clickable { onAction(FoldersUiAction.OnFolderClicked(it)) },
                text = it.name
            )
        }
    }
}

@UiStateful
@Composable
fun FoldersScreen() {
    val viewModel: FoldersViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val action = viewModel::onAction
    FoldersScreen(
        state = state,
        onAction = action
    )
}

@Preview
@Composable
private fun PlacesScreenPreview() {
    val state = FoldersUiState(
        folders = listOf(
            InventoryFolder(name = "kek"),
            InventoryFolder(name = "ded"),
        )
    )
    FoldersScreen(
        state = state,
        onAction = {}
    )
}