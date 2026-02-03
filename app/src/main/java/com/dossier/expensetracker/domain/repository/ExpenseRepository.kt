package com.dossier.expensetracker.domain.repository

import com.dossier.expensetracker.domain.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    fun getExpenses() :Flow<List<Expense>>
    suspend fun save(expense: Expense)
}