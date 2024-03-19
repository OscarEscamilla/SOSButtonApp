package com.racso.sosbutton.ui.screens.onboarding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.racso.sosbutton.data.repository.PreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val onboardingRepository: PreferencesRepository) :
    ViewModel() {

    val versionappSaved = mutableStateOf("")


    init {
        viewModelScope.launch {
            onboardingRepository.getSavedAppVersion().collect{
                versionappSaved.value = it
            }
        }
    }

    fun saveVersionAtFirstLauch(versionApp: String){
        viewModelScope.launch {
            onboardingRepository.saveAppVersion(versionApp)
        }
    }



}