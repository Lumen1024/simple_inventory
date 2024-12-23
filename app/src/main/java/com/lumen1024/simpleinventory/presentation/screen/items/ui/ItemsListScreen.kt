package com.lumen1024.simpleinventory.presentation.screen.items.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.presentation.screen.items.model.CounterUiAction
import com.lumen1024.simpleinventory.presentation.screen.items.model.ItemsListUiAction
import com.lumen1024.simpleinventory.presentation.screen.items.model.ItemsListUiState
import com.lumen1024.simpleinventory.presentation.screen.items.model.ItemsListViewModel
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
            InventoryListItem(
                it,
                onClick = { onAction(ItemsListUiAction.OnItemClicked(it)) },
                onIncrementClick = {
                    onAction(ItemsListUiAction.OnCounterAction(CounterUiAction.AddClicked))
                },
                onDecrementClick = {
                    onAction(ItemsListUiAction.OnCounterAction(CounterUiAction.MinusClicked))
                },
                onDecrementLongClick = {
                    onAction(ItemsListUiAction.OnCounterAction(CounterUiAction.MinusLongClicked))
                },
                modifier = Modifier.fillMaxWidth()
            )
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