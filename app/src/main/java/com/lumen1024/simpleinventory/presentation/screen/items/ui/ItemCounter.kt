package com.lumen1024.simpleinventory.presentation.screen.items.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemCounter(
    count: Int,
    onIncrementClick: () -> Unit,
    onDecrementClick: () -> Unit,
    onDecrementLongClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ItemCounterButton(
            onClick = onDecrementClick,
            onLongClick = onDecrementLongClick,
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Default.Remove,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.background
            )
        }
        Text(
            modifier = Modifier.width(32.dp),
            text = count.toString(),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        ItemCounterButton(
            onClick = onIncrementClick,
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemCounterButton(
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier
            .clip(CircleShape)
            .combinedClickable(
                onClick = onClick,
                onLongClick = onLongClick
            )
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.outlineVariant, CircleShape)
    ) { content() }
}

@Preview(widthDp = 120, heightDp = 36, showBackground = true)
@Composable
private fun ItemCounterPreview() {
    ItemCounter(
        count = 100,
        onIncrementClick = {},
        onDecrementClick = {},
        onDecrementLongClick = {}
    )
}