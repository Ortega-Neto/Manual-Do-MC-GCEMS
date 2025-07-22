package br.com.lconeto.manualdomc.roles.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lconeto.manualdomc.common.data.entity.RoleInfo
import br.com.lconeto.manualdomc.roles.data.RolesMemoryRepository
import kotlinx.coroutines.flow.Flow

class EditRolesViewModel(
    private val rolesMemoryRepository: RolesMemoryRepository
) : ViewModel() {

    suspend fun saveRoles(roles: List<RoleInfo>) {
        rolesMemoryRepository.saveRoles(roles)
    }

    suspend fun getRoles(): Flow<List<RoleInfo>> = rolesMemoryRepository.getRoles()

    class Factory(
        private val context: Context,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EditRolesViewModel::class.java)) {
                val repository = RolesMemoryRepository(context)
                return EditRolesViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
