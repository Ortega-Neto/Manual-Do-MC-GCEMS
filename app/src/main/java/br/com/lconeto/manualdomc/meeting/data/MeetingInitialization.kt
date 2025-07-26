package br.com.lconeto.manualdomc.meeting.data

import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.check.CheckList
import br.com.lconeto.manualdomc.common.data.entity.check.CheckObservation

object MeetingInitialization {
    private const val TITLE = "Check List – Iniciação ao Grau Iniciático"
    private const val STEP_1 = "Iniciar busca de novos candidatos (Escolas, Lojas Maçônicas, " +
        "Redes Sociais, Grupos de Amigos)"
    private const val STEP_2 = "Definição de membros e taxas junto à Comissão de Incremento de Novos Membros"
    private const val STEP_3 = "Preenchimento do formulário “O Caminho Começa Aqui”"
    private const val STEP_4 = "Organizar datas das Sindicâncias junto aos candidatos"
    private const val STEP_5 = "Preparar questionário de Sindicância"
    private const val STEP_6 = "Marcar visita ao candidato e sua família junto com o Conselho Consultivo"
    private const val STEP_7 = "Realizar visita"
    private const val STEP_8 = "Informar aos data da Cerimônia de Iniciação, taxas e mais detalhes referente " +
        "à iniciação do candidato"
    private const val STEP_9 = "Emitir parecer ao Capítulo por meio do Relatório de Sindicância"
    private const val STEP_10 = "Leitura do Relatório de Sindicância com o parecer da Comissão de " +
        "Incremento de Novo Membros"
    private const val STEP_11 = "Apresentação do Relatório de Sindicância deverá ser em Grau Iniciático"
    private const val STEP_12 = "Realizar votação"
    private const val STEP_13 = "Votação para aprovação deve ser em Grau DeMolay, sendo obrigatoriamente secreta"
    private const val STEP_14 = "Comunicar ao candidato da sua aprovação"
    private const val STEP_15 = "Auxilia-lo em questões, como, traje, dúvidas de horário e afins"
    private const val STEP_16 = "Manter contato para auxiliar o candidato em questões, como, traje, " +
        "dúvidas de horário e sempre ter atualização do mesmo"
    private const val STEP_17 = "Receber todas as taxas"
    private const val STEP_18 = "Criar o Pacote no SISDM com antecedência de no mínimo 7 (SETE) DIAS"
    private const val STEP_19 = "Ao realizar o pagamento via PIX é essencial colocar o número do pacote " +
        "da descrição do pagamento"
    private const val STEP_20 = "Enviar Comprovante de Pagamento (PIX) e nº do pacote no ticket através do SISDM"
    private const val STEP_21 = "Solicitar ao Grande Conselho Estadual o Ofício de autorização para concessão do Grau"
    private const val STEP_22 = "Enviar Convites"
    private const val STEP_23 = "Marcar Ensaio Ritualístico"
    private const val STEP_24 = "Verificar vendas, Coroa e joias"
    private const val STEP_25 = "Providenciar coquetel ou jantar"

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
            STEP_16,
            STEP_17,
            STEP_18,
            STEP_19,
            STEP_20,
            STEP_21,
            STEP_22,
            STEP_23,
            STEP_24,
            STEP_25,
        )
    )

    val observation = CheckObservation(
        textId = R.string.meeting_initialization_observation
    )
}
