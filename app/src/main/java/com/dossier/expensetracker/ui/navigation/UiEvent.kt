package com.dossier.expensetracker.ui.navigation

sealed interface UiEvent {
    data class Navigate(val route: String) : UiEvent
    data object ShowAddExpenseSheet : UiEvent
    data object HideAddExpenseSheet : UiEvent
}