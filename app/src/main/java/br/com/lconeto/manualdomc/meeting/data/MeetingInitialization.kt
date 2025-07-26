package br.com.lconeto.manualdomc.meeting.data

import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.check.CheckList
import br.com.lconeto.manualdomc.common.data.entity.check.CheckObservation

object MeetingInitialization {
    private const val TITLE = "Check List – Iniciação ao Grau Iniciático"
    private const val STEP_1 = "Comece a buscar novos candidatos em escolas, Lojas Maçônicas, " +
        "redes sociais e grupos de amigos."
    private const val STEP_2 = "Defina os membros e as taxas com a Comissão de Incremento de Novos Membros."
    private const val STEP_3 = "Preencha o formulário “O Caminho Começa Aqui”."
    private const val STEP_4 = "Organize as datas das Sindicâncias com os candidatos."
    private const val STEP_5 = "Prepare o questionário de Sindicância."
    private const val STEP_6 = "Agende uma visita ao candidato e sua família junto com o Conselho Consultivo."
    private const val STEP_7 = "Realize a visita."
    private const val STEP_8 = "Informe ao candidato a data da Cerimônia de Iniciação, as taxas e " +
        "outros detalhes sobre sua iniciação."
    private const val STEP_9 = "Emita um parecer ao Capítulo por meio do Relatório de Sindicância."
    private const val STEP_10 = "Leia o Relatório de Sindicância com o parecer da Comissão de Incremento " +
        "de Novos Membros."
    private const val STEP_11 = "Apresente o Relatório de Sindicância no Grau Iniciático."
    private const val STEP_12 = "Realize a votação."
    private const val STEP_13 = "A votação para aprovação deve ser secreta e ocorrer no Grau DeMolay."
    private const val STEP_14 = "Comunique o candidato sobre sua aprovação."
    private const val STEP_15 = "Ajude o candidato com questões sobre traje, horários e assuntos similares."
    private const val STEP_16 = "Mantenha contato para auxiliar o candidato com questões sobre traje, " +
        "dúvidas de horário e sempre mantenha-se atualizado sobre ele."
    private const val STEP_17 = "Receba todas as taxas."
    private const val STEP_18 = "Crie o Pacote no SISDM com no mínimo 7 dias de antecedência."
    private const val STEP_19 = "Ao pagar via PIX, coloque o número do pacote na descrição do pagamento."
    private const val STEP_20 = "Envie o Comprovante de Pagamento (PIX) e o número do pacote pelo ticket no SISDM."
    private const val STEP_21 = "Solicite ao Grande Conselho Estadual o Ofício de autorização para a concessão do Grau."
    private const val STEP_22 = "Envie os Convites."
    private const val STEP_23 = "Marque o Ensaio Ritualístico."
    private const val STEP_24 = "Verifique as vendas, a Coroa e as joias."
    private const val STEP_25 = "Providencie o coquetel ou jantar."

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
