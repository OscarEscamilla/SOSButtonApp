package com.racso.sosbutton.ui.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.racso.sosbutton.ui.navigation.HomeNav
import com.racso.sosbutton.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        Screen.Alarms,
        Screen.Profile,
        Screen.Settings
    )

    val darkColors = NavigationBarItemDefaults.colors(
        unselectedIconColor = MaterialTheme.colorScheme.inverseOnSurface,
        unselectedTextColor = MaterialTheme.colorScheme.inverseOnSurface,
        selectedTextColor = MaterialTheme.colorScheme.inverseOnSurface,
        selectedIconColor = Color.White
    )
    val lightColors = NavigationBarItemDefaults.colors(
        unselectedIconColor = Color.White,
        unselectedTextColor = Color.White,
        selectedTextColor = Color.White
    )



    Scaffold(
        content = { innerPadding ->
            HomeNav(navController = navController, innerPadding)
        },
        bottomBar = {
            NavigationBar(
                containerColor = if(isSystemInDarkTheme()) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
                tonalElevation = 8.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(getNavIcon(screen), contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = if(isSystemInDarkTheme()) darkColors else lightColors
                    )
                }
            }
        }
    )
}


fun getNavIcon(screen: Screen): ImageVector {
    return when(screen){
        Screen.Profile -> Icons.Filled.Person
        Screen.Alarms -> Icons.Filled.Notifications
        Screen.Settings -> Icons.Filled.Settings
        Screen.Login -> TODO()
        Screen.PasswordRecovery -> TODO()
        Screen.Register -> TODO()
        Screen.Home -> TODO()
        Screen.Onboarding -> TODO()
        Screen.Splash -> TODO()
        else -> { TODO() }
    }
}


