package com.dossier.expensetracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dossier.expensetracker.ui.screens.home.HomeScreen
import com.dossier.expensetracker.ui.screens.settings.SettingsScreen
import com.dossier.expensetracker.ui.screens.summary.SummaryScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Analytics.route) {
            SummaryScreen()
        }

        composable(Screen.Settings.route) {
            SettingsScreen()
        }
    }
}