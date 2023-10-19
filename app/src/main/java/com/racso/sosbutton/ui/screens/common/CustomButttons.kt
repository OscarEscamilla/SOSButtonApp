package com.racso.sosbutton.ui.screens.common

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun SkipOnboardingButton(navController: NavController, originDestination: String){
    Button(onClick = {
        navController.navigate("alerts"){
            popUpTo(originDestination){
                inclusive = true
            }
        }
    }) {
        Text(text = "skip tutorial")
    }
}