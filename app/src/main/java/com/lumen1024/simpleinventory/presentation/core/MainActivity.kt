package com.lumen1024.simpleinventory.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.lumen1024.simpleinventory.presentation.components.AppBottomNavigationBar
import com.lumen1024.simpleinventory.presentation.lib.navigation.ChannelNavigatorHost
import com.lumen1024.simpleinventory.presentation.theme.SimpleInventoryTheme
import com.lumen1024.simpleinventory.presentation.utils.getCurrentScreenAsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { SimpleInventoryTheme { AppContent(Modifier.fillMaxSize()) } }
    }
}

@Composable
fun AppContent(modifier: Modifier = Modifier) {
    val viewModel: NavigationViewModel = hiltViewModel()
    val navHostController = rememberNavController()
    ChannelNavigatorHost(viewModel.navigationChannel, navHostController)

    Scaffold(
        modifier = modifier,
        bottomBar = {
            AppBottomNavigationBar(
                currentScreen = navHostController.getCurrentScreenAsState().value
                    ?: Screen.ItemsList,
                onNavigate = viewModel::onBottomBarNavigate
            )
        }
    ) { innerPadding ->
        MainNavGraph(modifier = Modifier.padding(innerPadding), navHostController)
    }
}