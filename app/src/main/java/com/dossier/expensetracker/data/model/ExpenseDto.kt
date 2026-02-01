package com.dossier.expensetracker.data.model

import com.dossier.expensetracker.data.db.enums.ExpenseType
import java.time.ZonedDateTime

data class ExpenseDto (
    val id: Int,
    val title: String,
    val amount: Double,
    val description: String,
    val type: ExpenseType,
    val category : String,
    val date: ZonedDateTime
)