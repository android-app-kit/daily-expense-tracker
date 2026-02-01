package com.dossier.expensetracker.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dossier.expensetracker.domain.repository.LocalStorage
import com.dossier.expensetracker.domain.usecase.GetExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getExpenseUseCase: GetExpenseUseCase,
    private val localStorage: LocalStorage
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    init {
        observeItems()
    }

    private fun observeItems(){
        viewModelScope.launch {
            getExpenseUseCase()
                .catch { exception ->
                    _uiState.update { it.copy(error = exception.message) }
                }
                .collect { items ->
                    _uiState.update { it.copy(
                        items = items,
                        error = null
                    ) }
                }
        }
    }
}

