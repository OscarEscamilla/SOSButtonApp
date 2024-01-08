package com.racso.sosbutton.ui

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.racso.sosbutton.ui.navigation.RootNavGraph
import com.racso.sosbutton.ui.screens.onboarding.OnboardingViewModel
import com.racso.sosbutton.ui.theme.SOSButtonTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SOSButtonTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
        getCurrentVersion()
    }

    private fun getCurrentVersion(): String {
        val packageInfo: PackageInfo =
            applicationContext.packageManager.getPackageInfo(applicationContext.packageName, 0)
        return packageInfo.versionName
    }


}


