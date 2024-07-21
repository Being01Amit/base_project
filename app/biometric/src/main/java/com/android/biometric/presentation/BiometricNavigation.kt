package com.android.biometric.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.biometricNavGraph(
    navController: NavController?,
    biometricPrompt: BiometricPromptManager
) {
    navigation(startDestination = "BiometricScreen", route = "module_biometric") {
        composable("BiometricScreen") {
            BiometricScreen(biometricPrompt) {
                navController?.navigate("module_notification_manager")
            }
        }
    }
}
