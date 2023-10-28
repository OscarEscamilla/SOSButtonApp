package com.racso.sosbutton.ui

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.racso.sosbutton.R
import com.racso.sosbutton.ui.navigation.Screen
import com.racso.sosbutton.ui.screens.onboarding.OnboardingViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, onboardingViewModel: OnboardingViewModel = hiltViewModel()){

    LaunchedEffect(Unit) {
        delay(3000L)
        if (onboardingViewModel.versionappSaved.value.isNotEmpty()){
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
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
