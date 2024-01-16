package com.racso.sosbutton.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Colors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Switch
import androidx.compose.material3.Icon
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.racso.sosbutton.ui.theme.CustomSizes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.racso.sosbutton.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen(navController: NavHostController) {

    var checkedShake by remember { mutableStateOf(true) }
    var checkedPress by remember { mutableStateOf(true) }
    var itemsContacts = listOf("Oscar", "Pedro", "Fulanito")
    var itemsComunication = listOf("WhatsApp", "Llamada", "SMS")

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
            Text(
                text = "Gestos",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = CustomSizes.MEDIUM, top = CustomSizes.SMALL, bottom = CustomSizes.SMALL)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = CustomSizes.MEDIUM, end = CustomSizes.MEDIUM),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(130.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(CustomSizes.SMALL)
                    ) {
                        Text(
                            text = "Shake",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Agita tu telefono en situaciones de peligro para lanzar una alerta",
                            textAlign = TextAlign.Left,
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Switch(
                            modifier = Modifier.padding(top = CustomSizes.SMALL),
                            checked = checkedShake,
                            onCheckedChange = {
                                checkedShake = it
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(130.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(CustomSizes.SMALL)
                    ) {
                        Text(
                            text = "Press",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Presiona el boton de bloqueo tres veces para lanzar una alerta",
                            textAlign = TextAlign.Left,
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Switch(
                            modifier = Modifier.padding(top = CustomSizes.SMALL),
                            checked = checkedPress,
                            onCheckedChange = {
                                checkedPress = it
                            }
                        )
                    }
                }
            }
            // Trust contacts section
            Text(
                text = "Contactos de confianza",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = CustomSizes.MEDIUM, top = CustomSizes.SMALL, bottom = CustomSizes.SMALL)
            )
            itemsContacts.forEach {
                itemContact(name = it)
            }
            // Alarm media
            Text(
                text = "Medio de alarma",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = CustomSizes.MEDIUM, top = CustomSizes.SMALL, bottom = CustomSizes.SMALL)
            )
            itemsComunication.forEach {
                itemComunication(name = it)
            }
        }
}

@Composable
fun itemComunication(name: String){
    ElevatedCard(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = Color.DarkGray
    ),modifier = Modifier
        .padding(start = CustomSizes.MEDIUM, end = CustomSizes.MEDIUM, bottom = CustomSizes.SMALL)
        .wrapContentSize()){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = CustomSizes.MEDIUM, end = CustomSizes.MEDIUM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(name, style = MaterialTheme.typography.titleMedium)
            Switch(
                modifier = Modifier.padding(top = CustomSizes.SMALL),
                checked = true,
                onCheckedChange = {

                }
            )
        }
    }
}

@Composable
fun itemContact(name: String){
    ElevatedCard(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = Color.DarkGray
    ),modifier = Modifier
        .padding(start = CustomSizes.MEDIUM, end = CustomSizes.MEDIUM, bottom = CustomSizes.SMALL)
        .wrapContentSize()){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = CustomSizes.MEDIUM, end = CustomSizes.MEDIUM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column {
                Text(name, style = MaterialTheme.typography.titleMedium)
                Text("7751306549")
            }
            IconButton(onClick = { Log.e("","Contact clicked")}) {
                Icon(
                    Icons.Default.Create,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
