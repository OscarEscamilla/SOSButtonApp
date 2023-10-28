package com.racso.sosbutton.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.racso.sosbutton.ui.screens.home.HomeScreen
import com.racso.sosbutton.ui.screens.onboarding.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.racso.sosbutton.ui.SplashScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = "root",
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) { SplashScreen(navController) }
        composable(route = Screen.Onboarding.route) { OnboardingScreen(navController) }
        authGraph(navController = navController)
        composable(route = Screen.Home.route) { HomeScreen() }
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(route = "auth", startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route) { /* TODO */ }
        composable(route = Screen.Register.route) {  /* TODO */ }
        composable(route = Screen.PasswordRecovery.route) { /* TODO */ }
    }
}
