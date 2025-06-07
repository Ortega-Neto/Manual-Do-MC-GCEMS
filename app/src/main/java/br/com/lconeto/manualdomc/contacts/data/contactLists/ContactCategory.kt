package br.com.lconeto.manualdomc.contacts.data.contactLists

import android.os.Parcelable
import br.com.lconeto.manualdomc.contacts.data.Contact
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class ContactCategory(val title: String, val contacts: List<Contact>) : Parcelable {

    data object StateCouncil : ContactCategory(
        title = "Gabiente Estadual",
        contacts = StateCouncilContactsList.getStateCouncil()
    )

    data object GrandCouncil : ContactCategory(
        title = "Grande Conselho Estadual",
        contacts = GrandCouncilContactsList.getGrandCouncil()
    )

    data object ExecutiveOfficers : ContactCategory(
        title = "Oficiais Executivos",
        contacts = ExecutiveOfficersContactsList.getExecutiveOfficers()
    )

    data object RegionalMasterCouncilors : ContactCategory(
        title = "Mestres Conselheiros Regionais",
        contacts = RegionalMasterCouncilorsContactsList.getRegionalMasterCouncilors()
    )
}
