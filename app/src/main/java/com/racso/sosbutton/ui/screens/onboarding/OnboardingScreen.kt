package com.racso.sosbutton.ui.screens.onboarding

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.racso.sosbutton.R
import com.racso.sosbutton.ui.navigation.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel = hiltViewModel()
) {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (onboardingSkip) = createRefs()

        val pagerList = arrayOf(
            OnboardingPageData(
                stringResource(R.string.onboarding_body_first),
                R.drawable.onboarding_page_second
            ),
            OnboardingPageData(
                stringResource(R.string.onboarding_body_second),
                R.drawable.onboarding_page_first
            ),
            OnboardingPageData(
                stringResource(R.string.onboarding_body_third),
                R.drawable.onboarding_page_third
            ),
        )

        val pagerState = rememberPagerState(pageCount = {
            3
        })
        // Onboarding page contents
        HorizontalPager(
            state = pagerState,
        ) { page ->
            OnboardingPage(pagerList[page])
        }
        // Onboarding footer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .constrainAs(onboardingSkip) {
                    bottom.linkTo(parent.bottom)
                },
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    )
                }
            }
            Button(onClick = {
                onboardingViewModel.saveVersionAtFirstLauch("1.0")
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            }) {
                Text(text = stringResource(R.string.skip))
            }
        }
    }
}

data class OnboardingPageData(val text: String = "", val drawable: Int = 0)