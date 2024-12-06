package com.lumen1024.simpleinventory.presentation.screen.items_list.model

import androidx.compose.runtime.Immutable

@Immutable
sealed interface CounterUiAction {
    object AddClicked : CounterUiAction
    object MinusClicked : CounterUiAction
    object MinusLongClicked : CounterUiAction
}