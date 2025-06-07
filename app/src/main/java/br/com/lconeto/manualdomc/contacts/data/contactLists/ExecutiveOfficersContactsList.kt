package br.com.lconeto.manualdomc.contacts.data.contactLists

import br.com.lconeto.manualdomc.contacts.data.Contact

object ExecutiveOfficersContactsList {
    fun getExecutiveOfficers(): List<Contact> = listOf(
        firstRegionOfficer,
        secondRegionOfficer,
        thirdRegionOfficer,
        fifthRegionOfficer,
        sixthRegionOfficer
    )

    private val firstRegionOfficer = Contact(
        name = "Igor Oliveira de Assis",
        function = "Oficial Executivo - 1ª Região",
        cellphone = "(67) 9 9978-0797"
    )

    private val secondRegionOfficer = Contact(
        name = "Ervilário Alves da Cunha Júnior",
        function = "Oficial Executivo - 2ª Região",
        cellphone = "(67) 9 8150-9861"
    )

    private val thirdRegionOfficer = Contact(
        name = "Mario Junior Matsumoto Lopes",
        function = "Oficial Executivo - 3ª Região",
        cellphone = "(67) 9 9978-0797"
    )

    private val fifthRegionOfficer = Contact(
        name = "Sonner Arfux de Figueiredo",
        function = "Oficial Executivo - 5ª Região",
        cellphone = "(67) 9 9974-4577"
    )

    private val sixthRegionOfficer = Contact(
        name = "Fernando Vieira",
        function = "Oficial Executivo - 6ª Região",
        cellphone = "(67) 9 9975-2156"
    )
}
