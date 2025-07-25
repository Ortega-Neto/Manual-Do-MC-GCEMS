package br.com.lconeto.manualdomc.packages.data

import br.com.lconeto.manualdomc.common.data.entity.check.CheckList

object StepByStepPackage {
    private const val TITLE = "Passo a passo criação de pacote"
    private const val STEP_1 = "Abrir o SISDM"
    private const val STEP_2 = "Ir em Secretaria"
    private const val STEP_3 = "Procurar por Gestão > Pacotes"
    private const val STEP_4 = "Clicar em Novo Pacote Capítulo"
    private const val STEP_5 = "Clicar em Criar Pacote > OK"
    private const val STEP_6 = "Clicar em Editar Pacote"
    private const val STEP_7 = "Selecionar motivo do pacote"
    private const val STEP_8 = "Clicar em Adicionar ao Pacote (informar a(s) ação(ões) que deseja fazer)"
    private const val STEP_9 = "Registro incluído no pacote > OK"
    private const val STEP_10 = "Clicar em Concluir"
    private const val STEP_11 = "Confirmar conclusão > Sim > OK"

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
            STEP_11
        )
    )
}
