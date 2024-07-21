package com.android.baseproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.android.biometric.presentation.BiometricPromptManager
import com.android.biometric.presentation.biometricNavGraph
import com.android.notificationmanager.presentation.notificationNavGraph

@Composable
fun NavigationGraph(biometricPrompt: BiometricPromptManager) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "module_biometric") {
        biometricNavGraph(navController,biometricPrompt)
        notificationNavGraph(navController)
    }
}