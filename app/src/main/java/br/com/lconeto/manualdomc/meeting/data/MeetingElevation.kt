package br.com.lconeto.manualdomc.meeting.data

import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.check.CheckList
import br.com.lconeto.manualdomc.common.data.entity.check.CheckObservation

object MeetingElevation {
    private const val TITLE = "Check List – Iniciação ao Grau DeMolay"
    private const val STEP_1 = "Verificar o juramento dos iniciáticos."
    private const val STEP_2 = "Realizar o Exame de Proficiência (conforme Questionário na pág. 94)."
    private const val STEP_3 = "Efetuar a votação imediatamente após o exame."
    private const val STEP_4 = "A votação é aberta no Grau Iniciático, mas apenas membros aprovados " +
        "no exame de proficiência do Grau DeMolay votam."
    private const val STEP_5 = "Declarar o resultado da votação."
    private const val STEP_6 = "Garantir o recebimento de todas as taxas."
    private const val STEP_7 = "Criar o Pacote no SISDM com mínimo de 7 dias de antecedência."
    private const val STEP_8 = "Ao pagar via PIX, incluir o número do pacote na descrição."
    private const val STEP_9 = "Enviar o comprovante de pagamento (PIX) e o número do pacote via ticket no SISDM."
    private const val STEP_10 = "Solicitar ao Grande Conselho Estadual o Ofício de autorização para concessão do Grau."
    private const val STEP_11 = "Organizar a Sala Capitular."
    private const val STEP_12 = "Verificar se todos os materiais específicos da Cerimônia estão em ordem."

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
