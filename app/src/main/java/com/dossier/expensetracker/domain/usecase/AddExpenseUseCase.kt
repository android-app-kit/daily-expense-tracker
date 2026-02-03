package com.dossier.expensetracker.domain.usecase

import com.dossier.expensetracker.domain.model.Expense
import com.dossier.expensetracker.domain.repository.ExpenseRepository
import javax.inject.Inject

class AddExpenseUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {
    suspend fun save(expense : Expense) = repository.save(expense)
}