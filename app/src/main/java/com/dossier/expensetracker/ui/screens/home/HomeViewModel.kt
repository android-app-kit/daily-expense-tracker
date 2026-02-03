package com.dossier.expensetracker.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dossier.expensetracker.domain.repository.LocalStorage
import com.dossier.expensetracker.domain.usecase.GetExpenseUseCase
import com.dossier.expensetracker.ui.navigation.Screen
import com.dossier.expensetracker.ui.navigation.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getExpenseUseCase: GetExpenseUseCase,
    private val localStorage: LocalStorage
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState> = _uiState

    private val _event = Channel<UiEvent>(Channel.BUFFERED)

    val event = _event.receiveAsFlow()

    init {
        observeItems()
    }

    fun onAddExpenseClicked() {
        _uiState.update { it.copy(isAddExpenseSheetVisible = true) }
    }

    fun onAddExpenseDismissed() {
        _uiState.update { it.copy(isAddExpenseSheetVisible = false) }
    }

    fun onSummaryClicked() {
        sendEvent(UiEvent.Navigate(Screen.Summary.route))
    }

    fun onSettingsClicked() {
        sendEvent(UiEvent.Navigate(Screen.Settings.route))
    }

    private fun sendEvent(event: UiEvent) {
        viewModelScope.launch {
            _event.send(event)
        }
    }

    private fun observeItems(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            getExpenseUseCase()
                .onEach { items ->
                    _uiState.update {
                        it.copy(
                            items = items,
                            isLoading = false,
                            error = null
                        )
                    }
                }
                .catch { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message
                        )
                    }
                }
                .collect()
        }
    }
}

