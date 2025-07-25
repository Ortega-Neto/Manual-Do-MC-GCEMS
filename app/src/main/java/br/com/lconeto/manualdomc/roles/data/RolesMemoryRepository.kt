package br.com.lconeto.manualdomc.roles.data

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import br.com.lconeto.manualdomc.common.data.entity.role.RoleInfo
import br.com.lconeto.manualdomc.common.data.entity.role.Roles
import br.com.lconeto.manualdomc.common.data.preferences.DataStorageRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

class RolesMemoryRepository(
    private val context: Context,
    private val dataStorageRepository: DataStorageRepository = DataStorageRepository(context)
) {
    private val gson = Gson()

    suspend fun saveRoles(roles: List<RoleInfo>) {
        withContext(Dispatchers.IO) {
            val rolesJsonString = gson.toJson(roles)
            dataStorageRepository.save(ROLES_MAP_KEY, rolesJsonString)
        }
    }

    suspend fun getRoles(): Flow<List<RoleInfo>> {
        val roles = Roles().listOfRoles
        val rolesJsonString = dataStorageRepository.get(ROLES_MAP_KEY, "")

        return if (rolesJsonString.first().isNotEmpty()) {
            val type = object : TypeToken<List<RoleInfo>>() {}.type
            val resp: List<RoleInfo> = gson.fromJson(rolesJsonString.first(), type)
            return if (resp.isEmpty()) {
                flowOf(roles)
            } else {
                flowOf(resp)
            }
        } else {
            flowOf(roles)
        }
    }

    companion object {
        private val ROLES_MAP_KEY = stringPreferencesKey("roles_map_json")
    }
}
