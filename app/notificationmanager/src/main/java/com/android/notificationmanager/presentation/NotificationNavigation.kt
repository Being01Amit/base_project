package com.android.notificationmanager.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.notificationNavGraph(navController: NavController) {
    navigation(startDestination = "NotificationScreen", route = "module_notification_manager") {
        composable("NotificationScreen") {
            NotificationManagerScreen()
        }
    }
}