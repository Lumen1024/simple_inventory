package com.lumen1024.simpleinventory.presentation.screen.items_list.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListTopBarAction
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListTopBarUIState
import com.lumen1024.simpleinventory.presentation.screen.items_list.model.ItemsListTopBarViewModel
import com.lumen1024.simpleinventory.presentation.utils.UiStateful


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsListTopBar(
    state: ItemsListTopBarUIState,
    onAction: (ItemsListTopBarAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = state.query,
                onQueryChange = { onAction(ItemsListTopBarAction.OnSearchQueryChanged(it)) },
                onSearch = { onAction(ItemsListTopBarAction.OnSearchClicked) },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                modifier = Modifier, // TODO: Remove
                placeholder = { Text(text = "Search") },
                leadingIcon = { Icon(Icons.Default.Search, "") },
            )

        },
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = modifier,
    ) {
        LazyColumn {
            items(state.foundedItems) {
                InventoryListItem(it)
            }
        }
    }

}

@UiStateful
@Composable
fun ItemsListTopBar(modifier: Modifier = Modifier) {
    val viewModel: ItemsListTopBarViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val onAction = viewModel::onAction
    ItemsListTopBar(state, onAction, modifier)
}