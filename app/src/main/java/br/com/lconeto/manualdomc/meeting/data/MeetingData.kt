package br.com.lconeto.manualdomc.meeting.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MeetingData(
    var day: String,
    var startHour: String,
    var finishHour: String = "",
    var donations: String = "",
    var wordOfTheDay: String,
    var agendaItems: List<String>,
    var roles: String,
) : Parcelable {

    fun toStringMeeting(): String {
        val agendaString = if (agendaItems.isNotEmpty()) {
            agendaItems.joinToString(separator = "\n- ", prefix = "- ")
        } else {
            "Nenhum item de agenda."
        }

        return """
        Detalhes da Reunião:
        --------------------
        Data: $day
        Horário de Início: $startHour
        Horário de Término: ${if (finishHour.isNotBlank()) finishHour else "Não especificado"}
        Doações: ${if (donations.isNotBlank()) donations else "Nenhuma doação registrada"}
        Palavra do Dia: $wordOfTheDay

        Itens da Agenda:
        $agendaString
        
        Nominata:
        $roles
        """.trimIndent()
    }
}
