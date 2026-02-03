package com.dossier.expensetracker.ui.components.bottom_sheet

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dossier.expensetracker.data.db.enums.ExpenseType
import com.dossier.expensetracker.domain.model.Expense
import com.dossier.expensetracker.domain.usecase.AddExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val addExpenseUseCase: AddExpenseUseCase
) : ViewModel() {
    var title by mutableStateOf("")
        private set

    var amount by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    var category by mutableStateOf("")
        private set

    var isIncome by mutableStateOf(false)
        private set

    fun onTitleChange(value: String) {
        title = value
    }

    fun onAmountChange(value: String) {
        amount = value
    }

    fun onDescriptionChange(value: String) {
        description = value
    }

    fun onCategoryChange(value: String) {
        category = value
    }

    fun onIncomeToggle(value: Boolean) {
        isIncome = value
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveExpense() {
        val expense = Expense(
            id = 0,
            title = title,
            amount = amount.toDoubleOrNull() ?: 0.0,
            description = description,
            type = if (isIncome) ExpenseType.INCOME else ExpenseType.EXPENSE,
            category = category,
            date = ZonedDateTime.now()
        )
        viewModelScope.launch {
            addExpenseUseCase.save(expense = expense)
            // Reset fields after saving
            resetFields()
        }
    }

    private fun resetFields() {
        title = ""
        amount = ""
        description = ""
        category = ""
        isIncome = false
    }
}