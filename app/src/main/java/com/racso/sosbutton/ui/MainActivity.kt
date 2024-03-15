package com.racso.sosbutton.ui

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.racso.sosbutton.ui.navigation.RootNavGraph
import com.racso.sosbutton.ui.presentation.MainViewModel
import com.racso.sosbutton.ui.screens.onboarding.OnboardingViewModel
import com.racso.sosbutton.ui.services.ShakeDetectionService
import com.racso.sosbutton.ui.theme.SOSButtonTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SOSButtonTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
        getCurrentVersion()
        // start service
        if (!mainViewModel.isShakeServiceRunning){
            mainViewModel.isShakeServiceRunning = true
            startShakeService()
        }else{
            Log.i("ShakeDetectionService","Already is running...")
        }
    }

    private fun getCurrentVersion(): String {
        val packageInfo: PackageInfo =
            applicationContext.packageManager.getPackageInfo(applicationContext.packageName, 0)
        return packageInfo.versionName
    }
    override fun onDestroy() {
        super.onDestroy()
    }

    private fun startShakeService() {
        val serviceIntent = Intent(this, ShakeDetectionService::class.java)
        startService(serviceIntent)
        Log.i("ShakeDetectionService","Shake service started")
    }

    private fun stopShakeService() {
        val serviceIntent = Intent(this, ShakeDetectionService::class.java)
        stopService(serviceIntent)
        Log.i("ShakeDetectionService","Shake service started")
    }


}


