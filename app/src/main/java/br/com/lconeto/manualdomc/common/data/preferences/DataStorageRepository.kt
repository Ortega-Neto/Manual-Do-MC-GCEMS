package br.com.lconeto.manualdomc.common.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "GCEMS-Data")

class DataStorageRepository(private val context: Context) {

    /**
     * Salva um dado no Preferences DataStore.
     *
     * @param key A chave tipada da preferência (e.g., booleanPreferencesKey, stringPreferencesKey).
     * @param value O valor a ser salvo.
     */
    suspend fun <T> save(key: Preferences.Key<T>, value: T) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    /**
     * Obtém um Flow que emite o dado do Preferences DataStore.
     *
     * @param key A chave tipada da preferência (e.g., booleanPreferencesKey, stringPreferencesKey).
     * @param defaultValue O valor padrão a ser retornado se a chave não for encontrada.
     * @return Um Flow que emite o valor da preferência ou o defaultValue.
     */
    fun <T> get(key: Preferences.Key<T>, defaultValue: T): Flow<T> {
        return context.dataStore.data
            .map { preferences ->
                preferences[key] ?: defaultValue
            }
    }
}
