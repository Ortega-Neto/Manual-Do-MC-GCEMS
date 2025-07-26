package br.com.lconeto.manualdomc.common.presentation.meeting

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lconeto.manualdomc.common.data.repository.MeetingMemoryRepository
import br.com.lconeto.manualdomc.meeting.index.data.MeetingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MeetingMemoryViewModel(
    private val meetingMemoryRepository: MeetingMemoryRepository
) : ViewModel() {

    suspend fun saveMeeting(meeting: MeetingData) {
        withContext(Dispatchers.IO) {
            meetingMemoryRepository.saveMeeting(meeting)
        }
    }

    suspend fun getMeetings(): Flow<List<MeetingData>> {
        return withContext(Dispatchers.IO) {
            return@withContext meetingMemoryRepository.getMeetings()
        }
    }

    suspend fun deleteMeeting(meeting: MeetingData) {
        withContext(Dispatchers.IO) {
            meetingMemoryRepository.deleteMeeting(meeting)
        }
    }

    class Factory(
        private val context: Context,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MeetingMemoryViewModel::class.java)) {
                val repository = MeetingMemoryRepository(context)
                return MeetingMemoryViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
