package com.racso.sosbutton.data

data class AlertConfig(
    val active: Boolean = false,
    val timerActive: Boolean = false,
    val startDateTime: String = "",
    val endDateTime: String = ""
)
