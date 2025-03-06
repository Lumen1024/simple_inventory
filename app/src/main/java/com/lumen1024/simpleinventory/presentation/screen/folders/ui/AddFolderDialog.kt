package com.lumen1024.simpleinventory.presentation.screen.folders.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lumen1024.simpleinventory.domain.entity.InventoryFolder
import com.lumen1024.simpleinventory.domain.usecase.AddFolderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO ?????? refactor
@HiltViewModel
class AddFolderViewModel @Inject constructor(
    private val addFolderUseCase: AddFolderUseCase,
) : ViewModel(){
    fun addFolder(text: String) {
        viewModelScope.launch {
            addFolderUseCase(InventoryFolder(name = text))
        }
    }
}

@Composable
fun AddFolderDialog(onDismissRequest: () -> Unit) {
    val viewModel : AddFolderViewModel = hiltViewModel()
    Dialog(onDismissRequest = onDismissRequest) {
        var text by remember { mutableStateOf("") }
        Column {
            TextField(value = text, onValueChange = { text = it })
            Row {
                Button(onClick = { onDismissRequest() }) { Text("cancel") }
                Button(onClick = { viewModel.addFolder(text); onDismissRequest() }) { Text("save") }
            }
        }

    }
}