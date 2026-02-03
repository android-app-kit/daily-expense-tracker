package com.dossier.expensetracker.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.dossier.expensetracker.data.db.entity.ExpenseEntity
import com.dossier.expensetracker.data.model.ExpenseDto
import com.dossier.expensetracker.domain.model.Expense
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@RequiresApi(Build.VERSION_CODES.O)
fun ExpenseDto.toEntity() = ExpenseEntity(
    id = id,
    title = title,
    amount = amount,
    description = description,
    type = type,
    date = date.toEpochMillis(),
    category = category
)

@RequiresApi(Build.VERSION_CODES.O)
fun ExpenseEntity.toDto() = ExpenseDto(
    id = id,
    title = title,
    amount = amount,
    description = description,
    type = type,
    category = category,
    date = date.toZonedDateTime()
)

@RequiresApi(Build.VERSION_CODES.O)
fun ExpenseEntity.toModel() = Expense(
    id = id,
    title = title,
    amount = amount,
    description = description,
    type = type,
    category = category,
    date = date.toZonedDateTime()
)

@RequiresApi(Build.VERSION_CODES.O)
fun Expense.toEntity() = ExpenseEntity(
    id = id,
    title = title,
    amount = amount,
    description = description,
    type = type,
    category = category,
    date = date.toEpochMillis()
)

@RequiresApi(Build.VERSION_CODES.O)
fun ZonedDateTime.toEpochMillis(): Long = this.toInstant().toEpochMilli()

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toZonedDateTime(
    zoneId: ZoneId = ZoneId.systemDefault()
): ZonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(this), zoneId)

fun categoryIcon(iconKey: String) = when (iconKey) {
    "temple" -> null
    else -> {}
}