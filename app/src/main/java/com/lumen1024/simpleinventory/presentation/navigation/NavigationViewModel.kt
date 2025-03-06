package com.lumen1024.simpleinventory.presentation.navigation

import androidx.lifecycle.ViewModel
import com.lumen1024.simpleinventory.presentation.lib.channel_navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    navigator: Navigator
) : ViewModel() {

    val navigationChannel = navigator.navigationChannel
}