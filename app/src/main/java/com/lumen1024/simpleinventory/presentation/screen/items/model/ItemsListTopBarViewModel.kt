package com.lumen1024.simpleinventory.presentation.screen.items.model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ItemsListTopBarViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(ItemsListTopBarUIState())
    val state = _state.asStateFlow()

    fun onAction(action: ItemsListTopBarAction) {

    }
}