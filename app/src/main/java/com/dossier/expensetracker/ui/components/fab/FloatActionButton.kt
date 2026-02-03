package com.dossier.expensetracker.ui.components.fab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.dossier.expensetracker.ui.screens.home.HomeViewModel

@Composable
fun FloatingActionButtonComponent(
    viewModel: HomeViewModel
){
    FloatingActionButton(onClick = viewModel::onAddExpenseClicked) {
        Icon(Icons.Default.Add, contentDescription = "Add Expense")
    }
}