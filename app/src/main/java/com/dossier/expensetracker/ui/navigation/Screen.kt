package com.dossier.expensetracker.ui.navigation

sealed class Screen(val route : String) {
    data object Home : Screen("home")
    data object Summary : Screen("summary")
    data object Settings : Screen("settings")
}