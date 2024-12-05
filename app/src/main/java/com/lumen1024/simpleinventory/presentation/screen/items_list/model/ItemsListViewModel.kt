package com.lumen1024.simpleinventory.presentation.screen.items_list.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.usecase.AddItemUseCase
import com.lumen1024.simpleinventory.domain.usecase.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val addItemUseCase: AddItemUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ItemsListUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getItemsUseCase().collect {
                _state.value = _state.value.copy(items = it)
            }
        }
    }

    fun onUiAction(action: ItemsListUiAction) {
        viewModelScope.launch {
            addItemUseCase(InventoryItem(name = "12ed", count = 102))
        }
    }
}