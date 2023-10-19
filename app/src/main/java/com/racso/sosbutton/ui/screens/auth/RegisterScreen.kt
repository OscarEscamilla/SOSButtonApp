package com.racso.sosbutton.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    Surface {
        Scaffold() { padding ->
            Column(modifier = Modifier.padding(padding), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Login Screen", fontSize = 20.sp)
            }
        }
    }
}