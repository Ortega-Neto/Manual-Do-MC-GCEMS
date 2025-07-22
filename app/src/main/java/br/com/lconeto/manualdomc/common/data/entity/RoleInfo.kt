package br.com.lconeto.manualdomc.common.data.entity

data class RoleInfo(
    var occupantName: String = "",
    val acronym: String,
    val isNecessaryToStartReunion: Boolean = false
)
