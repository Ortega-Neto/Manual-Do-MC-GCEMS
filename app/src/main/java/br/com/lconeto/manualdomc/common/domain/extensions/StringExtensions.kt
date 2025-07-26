package br.com.lconeto.manualdomc.common.domain.extensions

import br.com.lconeto.manualdomc.common.data.entity.role.RoleInfo

fun String.extractOnlyNumbers(): String {
    return Regex("\\d+").findAll(this).joinToString("") { it.value }
}

fun List<RoleInfo>.toStringRoles(): String {
    return this.joinToString("\n") { roleInfo ->
        "${roleInfo.acronym}: ${roleInfo.occupantName}"
    }
}
