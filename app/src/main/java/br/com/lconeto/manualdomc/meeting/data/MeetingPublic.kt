package br.com.lconeto.manualdomc.meeting.data

import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.check.CheckList
import br.com.lconeto.manualdomc.common.data.entity.check.CheckObservation

object MeetingPublic {
    private const val TITLE = "Check List – Cerimônia Pública"
    private const val STEP_1 = "Verificar disponibilidade do templo"
    private const val STEP_2 = "Definir data em conjunto com o Conselho Consultivo"
    private const val STEP_3 = "Definir quais Cerimônias Públicas serão apresentadas"
    private const val STEP_4 = "Decidir os membros que apresentarão as Cerimônias, posteriormente " +
        "enviar para o DeMolay Orador o pdf da Cerimônia Pública. (disponível no SISDM em Downloads " +
        "(Categoria> Supremo Conselho; Subcatergoria> Cerimônias Públicas) > Escolher Cerimônia desejável)"
    private const val STEP_5 = "Verificar materiais a serem utilizados nas Cerimônias a serem apresentadas " +
        "(ex. rosas para a Cerimônia das Flores)"
    private const val STEP_6 = "Imprimir cópias do arquivo 26 – Abertura e Encerramento de Cerimônias " +
        "Públicas da Ordem DeMolay” disponível na área restrita do SISDM " +
        "(Downloads (Atos, Decretos, Editais e Outros)> Conteúdo> Cerimônias Públicas)"
    private const val STEP_7 = "Enviar Convite às Lojas Maçônicas"
    private const val STEP_8 = "Enviar Convites a outros Capítulos e outras paramaçônicas"
    private const val STEP_9 = "Enviar Convites ao Gabinete Estadual e Grande Conselho Estadual"
    private const val STEP_10 = "Distribuir assentos aos convidados"
    private const val STEP_11 = "Definir coquetel ou jantar em conjunto com o Conselho Consultivo"
    private const val STEP_12 = "Providenciar coquetel ou jantar para o evento"
    private const val STEP_13 = "Marcar ensaio com os Oficiais envolvidos"
    private const val STEP_14 = "Organizar a Sala Capitular de acordo com o Diagrama Nove (pág. 129)"
    private const val STEP_15 = "Reforçar os convites e confirmar presença"

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
            STEP_12,
            STEP_13,
            STEP_14,
            STEP_15,
        )
    )

    val observation = CheckObservation(
        textId = R.string.meeting_public_observation
    )
}
