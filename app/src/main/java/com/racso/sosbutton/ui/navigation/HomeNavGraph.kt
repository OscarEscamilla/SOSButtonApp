package com.racso.sosbutton.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.racso.sosbutton.ui.screens.home.HomeScreen
import com.racso.sosbutton.ui.screens.home.ProfileScreen
import com.racso.sosbutton.ui.screens.home.SettingsScreen

@Composable
fun HomeNav(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
        homeGraph(navController)
    }
}
fun NavGraphBuilder.homeGraph(navController: NavHostController){
    navigation(route = Screen.Home.route, startDestination = Screen.Alarms.route){
        composable(Screen.Alarms.route) { HomeScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
    }
}


