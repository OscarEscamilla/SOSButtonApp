package com.racso.sosbutton.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.racso.sosbutton.ui.screens.onboarding.*
import com.racso.sosbutton.ui.SplashScreen
import com.racso.sosbutton.ui.screens.auth.LoginScreen
import com.racso.sosbutton.ui.screens.home.BottomBar

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
        composable(route = Screen.Home.route) { BottomBar() }
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(route = "auth", startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route) {  LoginScreen(navController) }
        composable(route = Screen.Register.route) {  /* TODO */ }
        composable(route = Screen.PasswordRecovery.route) { /* TODO */ }
    }
}
