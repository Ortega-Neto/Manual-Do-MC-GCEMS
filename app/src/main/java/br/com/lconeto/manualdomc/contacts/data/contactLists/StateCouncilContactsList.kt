package br.com.lconeto.manualdomc.contacts.data.contactLists

import br.com.lconeto.manualdomc.contacts.data.Contact

object StateCouncilContactsList {
    fun getStateCouncil(): List<Contact> = listOf(
        stateMasterCounselor,
        assistantStateMasterCounselor,
        generalSecretary,
        projectsSecretary,
        marketingSecretary,
        ritualisticsSecretary,
        affiliateSecretary,
    )

    private val stateMasterCounselor = Contact(
        name = "Lucas Rodrigues Couto",
        function = "Mestre Conselheiro Estadual",
        email = "nobrecausage@gmail.com",
        cellphone = "(67) 9 9906-6270"
    )

    private val assistantStateMasterCounselor = Contact(
        name = "Thales Zimermann Duailibi",
        function = "Mestre Conselheiro Estadual Adjunto",
        email = "nobrecausage@gmail.com",
        cellphone = "(67) 9 9230-6144"
    )

    private val generalSecretary = Contact(
        name = "Luis Henrique da Silva Vieira",
        function = "Secretário Geral do Gabinete",
        email = "nobrecausage@gmail.com",
        cellphone = "(67) 9 9805-6524"
    )

    private val projectsSecretary = Contact(
        name = "Juan Luca Dutra da Silva",
        function = "Secretário de Projetos",
        cellphone = "(67) 9 8403-8066"
    )

    private val marketingSecretary = Contact(
        name = "Rafael Vasques Medina",
        function = "Secretário de Marketing",
        cellphone = "(67) 9 9348-1156"
    )

    private val ritualisticsSecretary = Contact(
        name = "Vitor Hugo Batista Garcia",
        function = "Secretário de Ritualística",
        cellphone = "(67) 9 9273-5775"
    )

    private val affiliateSecretary = Contact(
        name = "Roberto Ariel Favarão Belo",
        function = "Secretário de Afiliados",
        cellphone = "(67) 9 8403-8066"
    )
}
