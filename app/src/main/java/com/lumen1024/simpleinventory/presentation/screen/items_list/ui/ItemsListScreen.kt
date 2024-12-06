package com.lumen1024.simpleinventory.presentation.screen.items_list.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListUiAction
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListUiState
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListViewModel
import com.lumen1024.simpleinventory.presentation.utils.UiStateful

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsListScreen(
    state: ItemsListUiState,
    onAction: (ItemsListUiAction) -> Unit
) {
    LazyColumn {
        items(state.items, { it.id }) {
            InventoryListItem(it)
        }
    }
}

@UiStateful
@Composable
inline fun ItemsListScreen() {
    val viewModel: ItemsListViewModel = hiltViewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()
    val onAction = viewModel::onUiAction
    ItemsListScreen(
        state = state.value,
        onAction = onAction
    )
}

@Preview(heightDp = 500, showBackground = true)
@Composable
private fun ItemsListScreenPreview() {
    val state = ItemsListUiState(
        items = listOf(
            InventoryItem(name = "kek", count = 20),
            InventoryItem(name = "ded", count = 100),
        )
    )
    ItemsListScreen(
        state = state,
        onAction = {}
    )
}