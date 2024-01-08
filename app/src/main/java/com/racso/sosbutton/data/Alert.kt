package com.racso.sosbutton.data

data class Alert(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val config: AlertConfig = AlertConfig()
)