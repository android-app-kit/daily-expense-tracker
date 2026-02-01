package com.dossier.expensetracker.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dossier.expensetracker.data.db.enums.ExpenseType

@Entity(tableName = "expenses")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val amount: Double,
    val description: String,
    val type: ExpenseType,
    val category: String,
    val date: Long
)
