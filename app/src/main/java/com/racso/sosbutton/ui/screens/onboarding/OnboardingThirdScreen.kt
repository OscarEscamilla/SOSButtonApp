package com.racso.sosbutton.ui.screens.onboarding

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.racso.sosbutton.ui.screens.common.SkipOnboardingButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingThirdScreen(navController: NavController) {
    Scaffold() { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            Text(text = "OnboardingScreenThird", fontSize = 20.sp)
            Row {
                Button(onClick = {
                    navController.navigate("onboarding_second")
                }) {
                    Text(text = "back")
                }
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    navController.navigate("alerts")
                }) {
                    Text(text = "next")
                }
            }
            SkipOnboardingButton(navController, "onboarding_third")
        }
    }
}