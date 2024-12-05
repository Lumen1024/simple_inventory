package com.lumen1024.simpleinventory.presentation.screen.items_list.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lumen1024.simpleinventory.domain.entity.InventoryItem

@Composable
fun InventoryListItem(
    item: InventoryItem,
    onClick: () -> Unit = {},
    onIncrementClick: () -> Unit = {},
    onDecrementClick: () -> Unit = {},
    onDecrementLongClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                .size(56.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Email, "", Modifier.size(36.dp))
        }
        Column(modifier = Modifier.weight(1f).padding(horizontal = 16.dp)) {
            Text(text = item.name, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = "place in", // TODO: add place
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline
            )
        }
        ItemCounter(
            count = item.count,
            onIncrementClick = onIncrementClick,
            onDecrementClick = onDecrementClick,
            onDecrementLongClick = onDecrementLongClick
        )
    }
}

@Preview(widthDp = 320, heightDp = 300, showBackground = true)
@Composable
private fun InventoryListItemPreview() {
    val item = InventoryItem(name = "test", count = 100)
    InventoryListItem(item, modifier = Modifier.height( 56.dp))
}