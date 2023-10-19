package com.racso.sosbutton.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.racso.sosbutton.ui.screens.home.HomeScreen
import com.racso.sosbutton.ui.screens.onboarding.*

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "onboarding") {
        onboardingGraph(navController)
        authGraph(navController)
        alertsGraph(navController)
    }
}


fun NavGraphBuilder.onboardingGraph(navController: NavController){
    navigation(route = "onboarding", startDestination = "onboarding_first"){
        composable(route = "onboarding_first"){ OnboardingFirstScreen(navController) }
        composable(route = "onboarding_second"){ OnboardingSecondScreen(navController) }
        composable(route = "onboarding_third"){ OnboardingThirdScreen(navController) }
    }
}


fun NavGraphBuilder.authGraph(navController: NavController){
    navigation(route = "auth", startDestination = "login"){
        composable(route = "login"){ /* TODO */ }
        composable(route = "register"){  /* TODO */ }
        composable(route = "password_recover"){ /* TODO */ }
    }
}

fun NavGraphBuilder.alertsGraph(navController: NavController){
    navigation(route = "alerts", startDestination = "home"){
        composable(route = "home"){ HomeScreen(navController) }
        composable(route = "profile"){ /* TODO */ }
        composable(route = "config"){ /* TODO */ }
    }
}