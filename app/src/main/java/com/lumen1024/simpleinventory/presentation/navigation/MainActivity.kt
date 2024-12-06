package com.lumen1024.simpleinventory.presentation.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.lumen1024.simpleinventory.presentation.lib.channel_navigator.ChannelNavigatorLinker
import com.lumen1024.simpleinventory.presentation.scaffold_components.BottomBarHost
import com.lumen1024.simpleinventory.presentation.scaffold_components.HostingScaffold
import com.lumen1024.simpleinventory.presentation.scaffold_components.TopBarHost
import com.lumen1024.simpleinventory.presentation.theme.SimpleInventoryTheme
import com.lumen1024.simpleinventory.presentation.utils.getCurrentScreenAsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { SimpleInventoryTheme { HostingScaffold() } }
    }
}