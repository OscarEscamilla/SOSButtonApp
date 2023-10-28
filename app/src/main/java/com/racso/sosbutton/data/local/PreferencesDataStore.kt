package com.racso.sosbutton.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferencesDataStore @Inject constructor(@ApplicationContext val context: Context) {

    fun readValue(name: String): Flow<String> {
        val key = stringPreferencesKey(name)
        val preferenceFlow: Flow<String> = context.dataStore.data.map { preferences ->
            preferences[key] ?: ""
        }
        return preferenceFlow
    }

    suspend fun saveValue(name: String, value: String) {
        val key = stringPreferencesKey(name)
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

}