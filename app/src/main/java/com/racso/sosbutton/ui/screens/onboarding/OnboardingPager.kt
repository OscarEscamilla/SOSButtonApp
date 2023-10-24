package com.racso.sosbutton.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.racso.sosbutton.R
import com.racso.sosbutton.ui.screens.common.SkipOnboardingButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pagerList = arrayOf(
            OnboardingPage("Cuidamos de los tuyos, añade tres contactos de confianza para recibir tus alertas", R.drawable.onboarding_page_first),
            OnboardingPage("Presiona el boton de panico cuando te sientas en peligro y configura distintos gestos para lanzar alertas", R.drawable.onboarding_page_second),
            OnboardingPage("Comunica lo que quieras en tus alertas, personaliza el contenido de tus mensajes de alerta", R.drawable.onboarding_page_third),
        )
        val pagerState = rememberPagerState(pageCount = {
            3
        })
        HorizontalPager(
            state = pagerState,
        ) { page ->
            OnboardingScreen(pagerList[page])
        }
        SkipOnboardingButton(navController = navController, originDestination = "onboarding")
    }
}

data class OnboardingPage(val text: String = "", val drawable: Int = 0)