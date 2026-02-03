package com.dossier.expensetracker.ui.screens.home

import com.dossier.expensetracker.domain.model.Expense


data class HomeUiState(
    val items: List<Expense> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isAddExpenseSheetVisible: Boolean = false
)