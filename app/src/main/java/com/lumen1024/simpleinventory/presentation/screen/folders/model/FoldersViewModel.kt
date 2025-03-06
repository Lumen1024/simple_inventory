package com.lumen1024.simpleinventory.presentation.screen.folders.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import com.lumen1024.simpleinventory.domain.repository.FolderRepository
import com.lumen1024.simpleinventory.domain.usecase.GetAllFoldersUseCase
import com.lumen1024.simpleinventory.domain.usecase.GetPlacesUseCase
import com.lumen1024.simpleinventory.presentation.lib.channel_navigator.Navigator
import com.lumen1024.simpleinventory.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoldersViewModel @Inject constructor(
    private val getAllFoldersUseCase: GetAllFoldersUseCase,
    private val navigator: Navigator,
) : ViewModel() {

    private val _state = MutableStateFlow(FoldersUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getAllFoldersUseCase().collect {
                _state.value = FoldersUiState(it)
            }
        }
    }

    fun onAction(action: FoldersUiAction) {
        when (action) {
            is FoldersUiAction.OnFolderClicked -> {
                navigator.navigate(Screen.Items(action.folder.id))
            }
        }
    }
}