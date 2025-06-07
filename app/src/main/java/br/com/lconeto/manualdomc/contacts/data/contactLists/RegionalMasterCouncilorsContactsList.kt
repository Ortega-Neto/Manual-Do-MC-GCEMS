package br.com.lconeto.manualdomc.contacts.data.contactLists

import br.com.lconeto.manualdomc.contacts.data.Contact

object RegionalMasterCouncilorsContactsList {
    fun getRegionalMasterCouncilors(): List<Contact> = listOf(
        firstRegionMasterCouncilor,
        secondRegionMasterCouncilor,
        thirdRegionMasterCouncilor,
        fourthRegionMasterCouncilor,
        fifthRegionMasterCouncilor,
        sixthRegionMasterCouncilor
    )

    private val firstRegionMasterCouncilor = Contact(
        name = "José Tobias Jordão",
        function = "Mestre Conselheiro Regional - 1ª Região",
        cellphone = "(67) 9 9121-8090"
    )

    private val secondRegionMasterCouncilor = Contact(
        name = "Adalberto Alves",
        function = "Mestre Conselheiro Regional - 2ª Região",
        cellphone = "(67) 9 9609-1120"
    )

    private val thirdRegionMasterCouncilor = Contact(
        name = "Samuel Hasegawa",
        function = "Mestre Conselheiro Regional - 3ª Região",
        cellphone = "(67) 9 9692-3455"
    )

    private val fourthRegionMasterCouncilor = Contact(
        name = "Caio Junqueira Carriço",
        function = "Mestre Conselheiro Regional - 4ª Região",
        cellphone = "(67) 9 9607-1238"
    )

    private val fifthRegionMasterCouncilor = Contact(
        name = "Vitor Hugo Pereira Bonfim",
        function = "Mestre Conselheiro Regional - 5ª Região",
        cellphone = "(67) 9 9937-8628"
    )

    private val sixthRegionMasterCouncilor = Contact(
        name = "Roberto Ariel Favarão Belo",
        function = "Mestre Conselheiro Regional - 6ª Região",
        cellphone = "(67) 9 8403-8066"
    )
}
