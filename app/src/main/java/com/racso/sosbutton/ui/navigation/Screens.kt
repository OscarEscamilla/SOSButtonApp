package com.racso.sosbutton.ui.navigation

import androidx.annotation.StringRes
import com.racso.sosbutton.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Splash : Screen("splash", R.string.profile)
    object Onboarding : Screen("onboarding", R.string.profile)
    object Profile : Screen("profile", R.string.profile)
    object Home : Screen("home", R.string.profile)
    object Settings : Screen("settings", R.string.settings)
    object Alarms : Screen("alarms", R.string.alarms)
    object Login : Screen("login", R.string.alarms)
    object Register : Screen("register", R.string.alarms)
    object PasswordRecovery : Screen("password_recovery", R.string.alarms)
}