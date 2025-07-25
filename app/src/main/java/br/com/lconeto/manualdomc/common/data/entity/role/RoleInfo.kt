package br.com.lconeto.manualdomc.common.data.entity.role

data class RoleInfo(
    var occupantName: String = "",
    val acronym: String,
    val isNecessaryToStartReunion: Boolean = false
)
