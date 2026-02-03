package com.dossier.expensetracker.ui.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dossier.expensetracker.ui.components.bottom_sheet.AddExpenseBottomSheet
import com.dossier.expensetracker.ui.components.fab.FloatingActionButtonComponent
import com.dossier.expensetracker.ui.components.tab.TopAppNavBar
import com.dossier.expensetracker.ui.navigation.UiEvent
import kotlinx.coroutines.flow.collectLatest

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.event.collectLatest { event ->
            when(event) {
                is UiEvent.Navigate -> {
                    navController.navigate(event.route)
                }

                else -> {

                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppNavBar(
                onSummaryClick = viewModel::onSummaryClicked,
                onSettingsClick = viewModel::onSettingsClicked
            )
        },
        floatingActionButton = {
            FloatingActionButtonComponent(viewModel= viewModel)
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            uiState.error?.let {
                Text(text = it, modifier = Modifier.align(Alignment.Center))
            }

            LazyColumn {
                items(uiState.items) { expense ->
                    Text(text = "${expense.title}: ${expense.amount}", modifier = Modifier.padding(16.dp))
                }
            }

            if (uiState.isAddExpenseSheetVisible) {
                AddExpenseBottomSheet(onDismiss = viewModel::onAddExpenseDismissed)
            }
        }
    }
}




