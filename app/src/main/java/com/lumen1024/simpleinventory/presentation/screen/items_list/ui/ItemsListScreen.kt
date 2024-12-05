package com.lumen1024.simpleinventory.presentation.screen.items_list.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListUiAction
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListUiState
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListViewModel
import com.lumen1024.simpleinventory.presentation.utils.UiStateful

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemsListScreen(
    state: ItemsListUiState,
    onAction: (ItemsListUiAction) -> Unit
) {
    LazyColumn {
        stickyHeader() {
            Button(
                onClick = { onAction(ItemsListUiAction.OnButtonClicked) }
            ) { Text("Add Item") }
        }
        items(state.items) {
            InventoryListItem(item = it)
        }
    }
}

@UiStateful
@Composable
inline fun ItemsListScreen() {
    val viewModel : ItemsListViewModel = hiltViewModel()
    val state = viewModel.state.collectAsStateWithLifecycle()
    val onAction = viewModel::onUiAction
    ItemsListScreen(
        state = state.value,
        onAction = onAction
    )
}

@Preview
@Composable
private fun ItemsListScreenPreview() {

}