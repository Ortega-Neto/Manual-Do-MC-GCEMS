package br.com.lconeto.manualdomc.tickets.data

import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.check.CheckList
import br.com.lconeto.manualdomc.common.data.entity.check.CheckObservation

object StepByStepTicket {
    private const val TITLE = "Passo a passo - criação de ticket"
    private const val STEP_1 = "Clicar em Suporte"
    private const val STEP_2 = "Pedir ajuda"
    private const val STEP_3 = "Selecionar categoria a qual o ticket será destinado"
    private const val STEP_4 = "Colocar o Título do Pacote"
    private const val STEP_5 = "Vincular ao Capítulo"
    private const val STEP_6 = "Escreve o texto, justificando o motivo que o pacote foi aberto;"
    private const val STEP_7 = "Clicar em Enviar."

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

    fun getObservationForTicket(isAuth: Boolean): CheckObservation {
        val textId = if(isAuth) R.string.ticket_observation_auth else R.string.ticket_observation_email
        return CheckObservation(
            textId = textId
        )
    }
}
