package br.com.lconeto.manualdomc.packages.data

import br.com.lconeto.manualdomc.common.data.entity.check.CheckList

object SendPackageToCGEMS {
    private const val TITLE = "Passo a passo - Envio ao GCEMS"
    private const val STEP_1 = "Clicar em Suporte"
    private const val STEP_2 = "Pedir ajuda"
    private const val STEP_3 = "Selecionar categoria GCEMS ou Gabinete Estadual"
    private const val STEP_4 = "Vincular ao Capítulo"
    private const val STEP_5 = "Clicar em Criar Pacote > OK"
    private const val STEP_6 = "Escrever o texto, justificando o motivo que o pacote foi aberto"
    private const val STEP_7 = "Clicar em Enviar"

    val checkList = CheckList(
        tittle = TITLE,
        listItem = listOf(
            STEP_1,
            STEP_2,
            STEP_3,
            STEP_4,
            STEP_5,
            STEP_6,
            STEP_7,
        )
    )
}
