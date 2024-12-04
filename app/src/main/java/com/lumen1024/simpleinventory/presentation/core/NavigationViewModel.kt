package com.lumen1024.simpleinventory.presentation.core

import androidx.lifecycle.ViewModel
import com.lumen1024.simpleinventory.presentation.lib.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    val navigationChannel = navigator.navigationChannel

    fun onBottomBarNavigate(screen: Screen) {
        navigator.navigate(screen) {
            popUpTo(screen)
        }
    }
}