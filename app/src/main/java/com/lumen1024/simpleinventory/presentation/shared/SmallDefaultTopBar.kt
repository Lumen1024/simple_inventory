package com.lumen1024.simpleinventory.presentation.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallDefaultTopBar(
    modifier: Modifier = Modifier,
    title: String,
    iconAction: Pair<ImageVector, () -> Unit>? = null,
    onBack: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    ""
                )
            }
        },
        actions = {
            iconAction?.let {
                IconButton(onClick = iconAction.second) {
                    Icon(
                        iconAction.first,
                        ""
                    )
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun SmallDefaultTopBarPreview() {
    SmallDefaultTopBar(title = "Title")
}