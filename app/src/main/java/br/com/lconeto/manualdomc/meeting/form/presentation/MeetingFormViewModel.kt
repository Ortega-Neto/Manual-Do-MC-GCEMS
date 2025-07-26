package br.com.lconeto.manualdomc.meeting.form.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lconeto.manualdomc.common.data.entity.role.RoleInfo
import br.com.lconeto.manualdomc.roles.data.RolesMemoryRepository
import kotlinx.coroutines.flow.Flow

class MeetingFormViewModel(
    private val rolesMemoryRepository: RolesMemoryRepository
) : ViewModel() {

    suspend fun getRoles(): Flow<List<RoleInfo>> = rolesMemoryRepository.getRoles()

    class Factory(
        private val context: Context,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MeetingFormViewModel::class.java)) {
                val repository = RolesMemoryRepository(context)
                return MeetingFormViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
