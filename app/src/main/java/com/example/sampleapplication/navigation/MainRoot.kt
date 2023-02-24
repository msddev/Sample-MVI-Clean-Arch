package com.example.sampleapplication.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.provider.shouldUseDarkMode
import com.example.sampleapplication.provider.AppNavigationProvider
import com.example.sampleframework.SetupSystemUi
import com.example.theme.SampleColors
import com.example.theme.SampleTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency

@Composable
fun MainRoot(viewModel: MainViewModel = hiltViewModel(), finish: () -> Unit) {
    val navController = rememberNavController()

    val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()

    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntryAsState?.destination?.route
        ?: RootNavGraph.startRoute.startRoute.route

    if (destination == RootNavGraph.startRoute.startRoute.route) {
        BackHandler { finish() }
    }

    SampleTheme(darkTheme = isDarkMode) {
        SetupSystemUi(rememberSystemUiController(), SampleColors.primary)

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = SampleColors.background
        ) {
            DestinationsNavHost(
                navController = navController,
                navGraph = RootNavGraph,
                dependenciesContainerBuilder = {
                    dependency(AppNavigationProvider(navController))
                }
            )
        }
    }
}