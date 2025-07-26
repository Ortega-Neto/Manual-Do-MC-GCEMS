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
) : Parcelable
