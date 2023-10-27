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

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = "root",
        startDestination = "onboarding"
    ) {
        onboardingGraph(navController = navController)
        authGraph(navController = navController)
        composable(route = "home") {
            HomeScreen()
        }
    }
}


fun NavGraphBuilder.onboardingGraph(navController: NavController) {
    navigation(route = "onboarding", startDestination = "onboarding_pager") {
        composable(route = "onboarding_pager") { OnboardingPager(navController) }
    }
}


fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(route = "auth", startDestination = "login") {
        composable(route = "login") { /* TODO */ }
        composable(route = "register") {  /* TODO */ }
        composable(route = "password_recover") { /* TODO */ }
    }
}
