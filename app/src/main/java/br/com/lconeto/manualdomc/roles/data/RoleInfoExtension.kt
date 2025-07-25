package br.com.lconeto.manualdomc.roles.data

import br.com.lconeto.manualdomc.common.data.entity.RoleInfo

fun List<RoleInfo>.getRoleByAcronym(acronym: String): RoleInfo {
    return this.find { it.acronym == acronym }!!
}

fun List<RoleInfo>.updateOccupantName(acronym: String, occupantName: String) {
    val actualRole = this.find { it.acronym == acronym }!!
    actualRole.occupantName = occupantName
}
