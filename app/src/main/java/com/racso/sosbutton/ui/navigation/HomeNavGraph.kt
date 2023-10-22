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
import com.racso.sosbutton.R
import com.racso.sosbutton.ui.screens.home.AlertsScreen
import com.racso.sosbutton.ui.screens.home.ProfileScreen
import com.racso.sosbutton.ui.screens.home.SettingsScreen

@Composable
fun HomeNav(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
        homeGraph(navController)
    }
}
fun NavGraphBuilder.homeGraph(navController: NavHostController){
    navigation(route = "home", startDestination = Screen.Alarms.route){
        composable(Screen.Alarms.route) { AlertsScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
    }
}
sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Profile : Screen("profile", R.string.profile)
    object Settings : Screen("settings", R.string.settings)
    object Alarms : Screen("alarms", R.string.alarms)
}

