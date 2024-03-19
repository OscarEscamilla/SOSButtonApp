package com.racso.sosbutton.core

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts


fun Context.toast(msg: String){
    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
}