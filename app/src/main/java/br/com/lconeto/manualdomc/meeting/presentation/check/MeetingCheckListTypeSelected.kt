package br.com.lconeto.manualdomc.meeting.presentation.check

import br.com.lconeto.manualdomc.meeting.data.MeetingCheckListType

interface MeetingCheckListTypeSelected {
    fun navigateToCheckList(type: MeetingCheckListType)
}