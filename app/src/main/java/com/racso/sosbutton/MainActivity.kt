package com.racso.sosbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.racso.sosbutton.ui.navigation.Nav
import com.racso.sosbutton.ui.theme.SOSButtonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SOSButtonTheme {
                Nav()
            }
        }
    }
}


