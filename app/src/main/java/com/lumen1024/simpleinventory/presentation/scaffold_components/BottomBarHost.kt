package com.lumen1024.simpleinventory.presentation.scaffold_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import com.lumen1024.simpleinventory.presentation.shared.AppBottomNavigationBar

@Composable
fun BottomBarHost(
    currentScreen: Screen,
    modifier: Modifier = Modifier,
) {
    AppBottomNavigationBar(currentScreen, modifier)
}