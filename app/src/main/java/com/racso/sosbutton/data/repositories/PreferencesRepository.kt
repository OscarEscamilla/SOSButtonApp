package com.racso.sosbutton.data.repositories

import com.racso.sosbutton.data.local.PreferencesDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PreferencesRepository @Inject constructor(private val preferencesDataStore: PreferencesDataStore) {


    suspend fun saveAppVersion(currentVersion: String) {
        preferencesDataStore.saveValue("app_version_old", currentVersion)
    }


    fun getSavedAppVersion(): Flow<String> {
        return preferencesDataStore.readValue("app_version_old")
    }


}