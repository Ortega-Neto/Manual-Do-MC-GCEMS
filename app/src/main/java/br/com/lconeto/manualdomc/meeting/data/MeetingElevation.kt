package br.com.lconeto.manualdomc.meeting.data

import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.check.CheckList
import br.com.lconeto.manualdomc.common.data.entity.check.CheckObservation

object MeetingElevation {
    private const val TITLE = "Check List – Iniciação ao Grau DeMolay"
    private const val STEP_1 = "Verificar repasse do juramento dos iniciáticos"
    private const val STEP_2 = "Realizar Exame de Proficiência conforme Questionário para Exame (pág.94)"
    private const val STEP_3 = "Realizar votação logo após o término do exame"
    private const val STEP_4 = "Votação aberta no Grau Iniciático, apenas os membros aprovados no exame " +
        "de proficiência do Grau DeMolay votam"
    private const val STEP_5 = "Declarar resultado"
    private const val STEP_6 = "Receber todas as taxas"
    private const val STEP_7 = "Criar o Pacote no SISDM com antecedência de no mínimo 7 (SETE) Dias"
    private const val STEP_8 = "Ao realizar o pagamento via PIX é essencial colocar o numero do pacote " +
        "da descrição do pagamento"
    private const val STEP_9 = "Enviar Comprovante de Pagamento (PIX) e nº do pacote no ticket através do SISDM"
    private const val STEP_10 = "Solicitar ao Grande Conselho Estadual o Ofício de autorização para concessão do Grau"
    private const val STEP_11 = "Organizar a Sala Capitular"
    private const val STEP_12 = "Verificar se todo o material específico da Cerimonia está OK"

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
            STEP_8,
            STEP_9,
            STEP_10,
            STEP_11,
            STEP_12
        )
    )

    val observation = CheckObservation(
        textId = R.string.meeting_elevation_observation
    )
}
