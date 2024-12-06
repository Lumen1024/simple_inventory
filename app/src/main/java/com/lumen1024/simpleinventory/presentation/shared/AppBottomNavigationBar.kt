package com.lumen1024.simpleinventory.presentation.shared

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.lumen1024.simpleinventory.presentation.lib.channel_navigator.Navigator
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import com.lumen1024.simpleinventory.presentation.navigation.getIcon
import com.lumen1024.simpleinventory.presentation.navigation.getTitle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppBottomNavigationBarViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {
    fun onNavigate(screen: Screen) {
        navigator.navigate(screen) {
            popUpTo(Screen.ItemsList)
        }
    }
}

@Composable
fun AppBottomNavigationBar(
    currentScreen: Screen,
    modifier: Modifier = Modifier,
    viewModel: AppBottomNavigationBarViewModel = hiltViewModel()
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = (currentScreen == Screen.ItemsList),
            onClick = { viewModel.onNavigate(Screen.ItemsList) },
            icon = { Icon(Screen.ItemsList.getIcon(), currentScreen.getTitle()) },
        )
        NavigationBarItem(
            selected = (currentScreen == Screen.ModifyItem),
            onClick = { viewModel.onNavigate(Screen.ModifyItem) },
            icon = { Icon(Screen.ModifyItem.getIcon(), currentScreen.getTitle()) },
        )
        NavigationBarItem(
            selected = (currentScreen == Screen.Settings),
            onClick = { viewModel.onNavigate(Screen.Settings) },
            icon = { Icon(Screen.Settings.getIcon(), currentScreen.getTitle()) },
        )
    }
}