package br.com.lconeto.manualdomc.common.data.repository

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import br.com.lconeto.manualdomc.common.data.preferences.DataStorageRepository
import br.com.lconeto.manualdomc.meeting.index.data.MeetingData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

class MeetingMemoryRepository(
    private val context: Context,
    private val dataStorageRepository: DataStorageRepository = DataStorageRepository(context)
) {
    private val gson = Gson()

    suspend fun saveMeeting(meeting: MeetingData) {
        getMeetings().collect {
            val meetings = if (it.isEmpty()) {
                mutableListOf()
            } else {
                it as MutableList<MeetingData>
            }

            meetings.add(meeting)
            saveMeetings(meetings)
        }
    }

    private suspend fun saveMeetings(meeting: List<MeetingData>) {
        withContext(Dispatchers.IO) {
            val rolesJsonString = gson.toJson(meeting)
            dataStorageRepository.save(MEETING_MAP_KEY, rolesJsonString)
        }
    }

    suspend fun getMeetings(): Flow<List<MeetingData>> {
        val meetings = emptyList<MeetingData>()
        val rolesJsonString = dataStorageRepository.get(MEETING_MAP_KEY, "")

        return if (rolesJsonString.first().isNotEmpty()) {
            val type = object : TypeToken<List<MeetingData>>() {}.type
            val resp: List<MeetingData> = gson.fromJson(rolesJsonString.first(), type)
            return if (resp.isEmpty()) {
                flowOf(meetings)
            } else {
                flowOf(resp)
            }
        } else {
            flowOf(meetings)
        }
    }

    companion object {
        private val MEETING_MAP_KEY = stringPreferencesKey("meetings_map_json")
    }
}
