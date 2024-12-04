package com.lumen1024.simpleinventory.presentation.screen.items_list.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lumen1024.simpleinventory.domain.entity.InventoryItem

@Composable
fun InventoryListItem(
    item: InventoryItem,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = item.name)
        Text(text = item.count.toString())
    }
}

@Preview
@Composable
private fun InventoryListItemPreview() {
    InventoryListItem(InventoryItem("test", 1))
}