package com.racso.sosbutton.ui.screens.home

import android.Manifest
import android.content.pm.PackageManager
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.racso.sosbutton.R
import com.racso.sosbutton.ui.screens.common.SimpleAlertDialog
import com.racso.sosbutton.ui.theme.CustomSizes

@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    var openAlertDialog by remember { mutableStateOf(false) }
    val itemList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    var username = "Oscar"

    val permissionLaucher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (!isGranted) {
            openAlertDialog = true
        }
    }

    when {
        openAlertDialog -> {
            SimpleAlertDialog(
                onDismissRequest = { openAlertDialog = false },
                onConfirmation = { openAlertDialog = false },
                dialogTitle = "Atención",
                dialogText = "Si deniegas el permiso de enviar SMS no podremos enviar tus alertas a tuscontactos de confiaza",
                icon = Icons.Default.Info
            )
        }
    }

    fun sendSMS() {
        // Check permission
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.SEND_SMS
            ) -> {
                try {
                    val smsManager = SmsManager.getDefault() as SmsManager
                    smsManager.sendTextMessage("+527751306549", null, "example message", null, null)
                    Toast.makeText(context, "Enviando alerta...", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    e.message?.let { Log.e("SMS", it) }
                }
            }

            else -> {
                permissionLaucher.launch(Manifest.permission.SEND_SMS)
            }
        }
    }


    //  ************** UI ROOT CONTAINER ****************
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = CustomSizes.MEDIUM),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Profile user image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
                            CircleShape
                        )
                )
                Text(
                    text = "Hola $username!",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(end = CustomSizes.MEDIUM, start = CustomSizes.MEDIUM)
                )
            }
            Text(
                text = "Te ayudamos a mantener a tu familia y a ti a salvo",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(end = CustomSizes.MEDIUM, start = CustomSizes.MEDIUM)
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = CustomSizes.MEDIUM),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(modifier = Modifier.fillMaxWidth(), onClick = {
                    sendSMS()
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "alarm icon",
                        modifier = Modifier.size(150.dp)
                    )
                }
                Text(
                    text = "Presiona el boton de alerta para lanzar una.",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = CustomSizes.MEDIUM, end = CustomSizes.MEDIUM),
                    textAlign = TextAlign.Justify
                )
            }
            Text(
                text = "Tips",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    start = CustomSizes.MEDIUM,
                    top = CustomSizes.MEDIUM,
                    bottom = CustomSizes.SMALL
                )
            )
            LazyRow {
                items(itemList) { item ->
                    Spacer(modifier = Modifier.padding(10.dp))
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        modifier = Modifier
                            .size(width = 230.dp, height = 200.dp)
                    ) {
                        Text(
                            text = "Elevated $item",
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }

}