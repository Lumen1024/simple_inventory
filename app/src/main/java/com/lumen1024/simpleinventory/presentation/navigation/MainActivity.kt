package com.lumen1024.simpleinventory.presentation.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.lumen1024.simpleinventory.presentation.scaffold_components.HostingScaffold
import com.lumen1024.simpleinventory.presentation.theme.SimpleInventoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { SimpleInventoryTheme { HostingScaffold() } }
    }
}