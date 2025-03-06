package com.lumen1024.simpleinventory.presentation.scaffold_components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lumen1024.simpleinventory.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHost(
    currentScreen: Screen,
    modifier: Modifier = Modifier,
) {
    when (currentScreen) {
        Screen.Folders -> TopAppBar(title = { Text(text = "Folders") }, modifier = modifier)
//        Screen.Items -> ItemsListTopBar(modifier)
//        Screen.Item, Screen.Settings -> {
//            val title = when (currentScreen) {
//                Screen.Item -> "Modify Item"
//                Screen.Settings -> "Settings"
//                Screen.Items -> TODO()
//                Screen.Folders -> TODO()
//            }
//            SmallDefaultTopBar(title = title)
//        }
        else -> {}
    }
}