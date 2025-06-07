package br.com.lconeto.manualdomc.contacts.data.contactLists

import br.com.lconeto.manualdomc.contacts.data.Contact

object GrandCouncilContactsList {
    fun getGrandCouncil(): List<Contact> = listOf(
        grandMasterState,
        assistantGrandMasterState,
        grandSecretaryState,
        assistantGrandSecretaryState,
        assistantGrandTreasurerState,
        grandTreasurerState,
        grandOratorState,
        assistantGrandOratorState,
    )

    private val grandMasterState = Contact(
        name = "André Luis Constantino Barbosa",
        function = "Grande Mestre Estadual",
        cellphone = "(67) 9 8175-2652"
    )

    private val assistantGrandMasterState = Contact(
        name = "Dirceu Gindri",
        function = "Grande Mestre Estadual Adjunto",
        cellphone = "(67) 9 9287-6369"
    )

    private val grandSecretaryState = Contact(
        name = "Bruno Candia Dalla Nora",
        function = "Grande Secretário Estadual",
        cellphone = "(67) 9 8175-2652"
    )

    private val assistantGrandSecretaryState = Contact(
        name = "Diogo Lopes",
        function = "Grande Secretário Estadual Adj",
        cellphone = "(67) 9 9940-6340"
    )

    private val assistantGrandTreasurerState = Contact(
        name = "Manoel Douglas",
        function = "Grande Tesoureiro Estadual Adjunto",
        cellphone = "(67) 9 9971-1609"
    )

    private val grandTreasurerState = Contact(
        name = "Herbert Assunção de Freitas",
        function = "Grande Tesoureiro Estadual",
        cellphone = "(67) 9 9849-9127"
    )

    private val grandOratorState = Contact(
        name = "Rafael Castello Monaco Dib",
        function = "Grande Orador Estadual",
        cellphone = "(67) 9 9849-9127"
    )

    private val assistantGrandOratorState = Contact(
        name = "Janes Couto",
        function = "Grande Orador Estadual Adjunto",
        cellphone = "(67) 9 9982-6270"
    )
}
