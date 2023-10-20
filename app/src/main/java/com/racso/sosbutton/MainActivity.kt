package com.racso.sosbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.racso.sosbutton.ui.navigation.RootNav
import com.racso.sosbutton.ui.theme.SOSButtonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SOSButtonTheme {
                RootNav(navController = rememberNavController())
            }
        }
    }
}


