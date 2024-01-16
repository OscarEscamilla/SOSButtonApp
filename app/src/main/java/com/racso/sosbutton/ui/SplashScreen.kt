package com.racso.sosbutton.ui

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.racso.sosbutton.R
import com.racso.sosbutton.ui.navigation.Screen
import com.racso.sosbutton.ui.screens.onboarding.OnboardingViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, onboardingViewModel: OnboardingViewModel = hiltViewModel()){

    val userIsLogedIn = true

    LaunchedEffect(Unit) {
        delay(1000L)
        if (onboardingViewModel.versionappSaved.value.isNotEmpty()){
            if (!userIsLogedIn){
                navController.popBackStack()
                navController.navigate(Screen.Login.route)
            }else{
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            }
        }else{
            navController.popBackStack()
            navController.navigate(Screen.Onboarding.route)
        }
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.red_alarm_icon), contentDescription = "")
    }
}
