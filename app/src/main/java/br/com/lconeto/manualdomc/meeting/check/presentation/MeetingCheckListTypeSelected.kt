package br.com.lconeto.manualdomc.meeting.check.presentation

import br.com.lconeto.manualdomc.meeting.check.data.MeetingCheckListType

interface MeetingCheckListTypeSelected {
    fun navigateToCheckList(type: MeetingCheckListType)
}