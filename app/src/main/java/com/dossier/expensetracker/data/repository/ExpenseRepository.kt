package com.dossier.expensetracker.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.dossier.expensetracker.data.db.dao.ExpenseDao
import com.dossier.expensetracker.data.mapper.toEntity
import com.dossier.expensetracker.data.mapper.toModel
import com.dossier.expensetracker.domain.model.Expense
import com.dossier.expensetracker.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val expenseDao: ExpenseDao
) : ExpenseRepository{

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getExpenses(): Flow<List<Expense>> {
        return expenseDao.getAllExpenses().map{entities -> entities.map{it.toModel()}}
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun save(expense: Expense){
        expenseDao.insertExpense(expense = expense.toEntity())
    }
}