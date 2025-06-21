package br.com.lconeto.manualdomc.contacts.data.contactLists

import android.os.Parcelable
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.contacts.data.Contact
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class ContactCategory(
    val title: String,
    val acronym: String,
    val icon: Int,
    val contacts: List<Contact>
) : Parcelable {

    data object StateCouncil : ContactCategory(
        title = "Gabiente Estadual",
        acronym = "GE",
        icon = R.drawable.ic_sc_symbol,
        contacts = StateCouncilContactsList.getStateCouncil()
    )

    data object GrandCouncil : ContactCategory(
        title = "Grande Conselho Estadual",
        acronym = "GCE",
        icon = R.drawable.ic_gc_symbol,
        contacts = GrandCouncilContactsList.getGrandCouncil()
    )

    data object ExecutiveOfficers : ContactCategory(
        title = "Oficiais Executivos",
        acronym = "OE",
        icon = R.drawable.ic_eo_symbol,
        contacts = ExecutiveOfficersContactsList.getExecutiveOfficers()
    )

    data object RegionalMasterCouncilors : ContactCategory(
        title = "Mestres Conselheiros Regionais",
        acronym = "MCR",
        icon = R.drawable.ic_rmc_symbol,
        contacts = RegionalMasterCouncilorsContactsList.getRegionalMasterCouncilors()
    )
}
