package com.example.welcome.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.welcome.onboarding.OnBoardingScreen

const val ON_BOARDING_SCREEN = "onBoarding_screen"

@Composable
fun WelcomeNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ON_BOARDING_SCREEN
    ) {
        composable(route = ON_BOARDING_SCREEN) {
            OnBoardingScreen()
        }
    }
}