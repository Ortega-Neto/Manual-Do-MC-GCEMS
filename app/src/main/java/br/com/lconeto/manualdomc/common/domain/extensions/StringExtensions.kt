package br.com.lconeto.manualdomc.common.domain.extensions

fun String.extractOnlyNumbers(): String {
    return Regex("\\d+").findAll(this).joinToString("") { it.value }
}
