package com.dossier.expensetracker.domain.model

import com.dossier.expensetracker.data.db.enums.ExpenseType
import java.time.ZonedDateTime

data class Expense (
    val id: Int,
    val title: String,
    val amount: Double,
    val description: String,
    val type: ExpenseType,
    val category : String,
    val date: ZonedDateTime
)