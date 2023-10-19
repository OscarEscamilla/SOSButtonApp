package com.racso.sosbutton.ui.screens.onboarding

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.racso.sosbutton.ui.screens.common.SkipOnboardingButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingFirstScreen(navController: NavController) {
    Scaffold() { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "OnboardingScreenFirst", fontSize = 20.sp)
            Row {
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    navController.navigate("onboarding_second")
                }) {
                    Text(text = "next")
                }
            }
            SkipOnboardingButton(navController,"onboarding_first")
        }
    }

}