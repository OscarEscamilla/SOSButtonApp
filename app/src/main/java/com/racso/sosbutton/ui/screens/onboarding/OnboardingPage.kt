package com.racso.sosbutton.ui.screens.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.racso.sosbutton.R
import com.racso.sosbutton.ui.screens.home.SettingsScreen
import com.racso.sosbutton.ui.theme.SOSButtonTheme


@Composable
fun OnboardingPage(pageData: OnboardingPageData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(50.dp)
    ) {
        Image(
            modifier = Modifier.height(350.dp),
            painter = painterResource(id = pageData.drawable),
            contentDescription = pageData.text,
            contentScale = ContentScale.Fit
        )
        Text(
            modifier = Modifier.padding(20.dp),
            text = pageData.text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "HomeScreenPreviewDark"
)
@Preview(showBackground = true)
@Composable
fun OnboardingPagePreview(){
    SOSButtonTheme {
        OnboardingPage(OnboardingPageData(
            stringResource(R.string.onboarding_body_second),
            R.drawable.onboarding_page_first
        ))
    }
}
