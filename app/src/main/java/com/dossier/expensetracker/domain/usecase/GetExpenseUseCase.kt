package com.dossier.expensetracker.domain.usecase


import com.dossier.expensetracker.domain.model.Expense
import com.dossier.expensetracker.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExpenseUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {
    operator fun invoke() : Flow<List<Expense>> = repository.getExpenses()
}