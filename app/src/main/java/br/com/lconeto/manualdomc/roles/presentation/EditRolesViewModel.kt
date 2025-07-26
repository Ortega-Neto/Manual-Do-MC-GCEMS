package br.com.lconeto.manualdomc.roles.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lconeto.manualdomc.common.data.entity.role.RoleInfo
import br.com.lconeto.manualdomc.roles.data.RolesMemoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class EditRolesViewModel(
    private val rolesMemoryRepository: RolesMemoryRepository
) : ViewModel() {

    suspend fun saveRoles(roles: List<RoleInfo>) {
        withContext(Dispatchers.IO) {
            rolesMemoryRepository.saveRoles(roles)
        }
    }

    suspend fun getRoles(): Flow<List<RoleInfo>> {
        return withContext(Dispatchers.IO) {
            return@withContext rolesMemoryRepository.getRoles()
        }
    }

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
