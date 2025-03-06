package com.lumen1024.simpleinventory.presentation.screen.items.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.usecase.GetItemsByPlaceUseCase
import com.lumen1024.simpleinventory.domain.usecase.RemoveItemUseCase
import com.lumen1024.simpleinventory.domain.usecase.UpdateItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val getItemsByPlaceUseCase: GetItemsByPlaceUseCase,
    private val updateItemUseCase: UpdateItemUseCase,
    private val removeItemUseCase: RemoveItemUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ItemsListUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
//            getItemsByPlaceUseCase().collect {
//                _state.value = _state.value.copy(items = it)
//            }
        }
    }

    fun onUiAction(action: ItemsListUiAction) {
        when (action) {
            is ItemsListUiAction.OnCounterAction -> onCounterUiAction(action.item, action.counterAction)
            is ItemsListUiAction.OnItemClicked -> { }// TODO: Navigate to modify item screen
        }
    }

    private fun onCounterUiAction(item: InventoryItem, action: CounterUiAction) {
        when (action) {
            CounterUiAction.AddClicked -> {
                viewModelScope.launch {
                    updateItemUseCase(item.copy(count = item.count + 1))
                }
            }

            CounterUiAction.MinusClicked -> {
                viewModelScope.launch {
                    updateItemUseCase(item.copy(count = item.count - 1))
                }
            }
            CounterUiAction.MinusLongClicked -> {
//                viewModelScope.launch {
//                    removeItemUseCase(item.id)
//                }
            }
        }
    }


}