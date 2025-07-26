package br.com.lconeto.manualdomc.meeting.index.data.types

import br.com.lconeto.manualdomc.common.data.entity.check.CheckList

object MeetingClassRoomOrganization {
    private const val TITLE = "Check List – Organização da Sala Capitular"
    private const val STEP_1 = "Organizar a Sala Capitular e dispor os castiçais no altar de acordo " +
        "com o Diagrama Nove (pág. 129)"
    private const val STEP_2 = "Verificar velas, fósforos/isqueiros, toalhas de mesa, livros escolares, " +
        "Coroa da Juventude, bastão do MCer"
    private const val STEP_3 = "Verificar capas e joias para todos os cargos ritualísticos"
    private const val STEP_4 = "Verificar Marcador de Páginas (utilização correta na pág. 6)"
    private const val STEP_5 = "Verificar Bandeira Nacional e da Ordem DeMolay, se houver " +
        "(caso sejam as duas bandeiras, manter a bandeira nacional mais à esquerda possível da Sala " +
        "Capitular, havendo uma terceira, a nacional deve estar centralizada entre elas)"
    private const val STEP_6 = "Verificar o Estandarte do Capítulo"
    private const val STEP_7 = "Testar o som e harmonia ritualística"
    private const val STEP_8 = "Verificar “bolsa” do Tronco da Solidariedade"

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
        )
    )
}
