package com.android.biometric.presentation

import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.biometric.presentation.BiometricPromptManager.BioMetricResult

@Composable
fun BiometricScreen(
    biometricPrompt: BiometricPromptManager,
    onSuccess: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val bioMetricResult by biometricPrompt.promptResult.collectAsState(initial = null)

        val enrollLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult(),
            onResult = {
                println("ActivityResult :$it")
            }
        )
        LaunchedEffect(bioMetricResult) {
            if (bioMetricResult is BioMetricResult.AuthenticationNotSet) {
                if (Build.VERSION.SDK_INT >= 30) {
                    val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                        putExtra(
                            Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                            BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                        )
                    }
                    enrollLauncher.launch(enrollIntent)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                biometricPrompt.showBiometricPrompt(
                    title = "Sample Prompt",
                    description = "Description"
                )
            }) {
                Text(text = "Authenticate")
            }

            Spacer(modifier = Modifier.height(16.dp))

            bioMetricResult?.let { result ->

                when (result) {
                    is BioMetricResult.AuthenticationError -> TODO()
                    BioMetricResult.AuthenticationFailed -> TODO()
                    BioMetricResult.AuthenticationNotSet -> TODO()
                    BioMetricResult.AuthenticationSuccess -> {
                        onSuccess()
                    }

                    BioMetricResult.FeatureUnavailable -> TODO()
                    BioMetricResult.HardwareUnavailable -> TODO()
                }


                /*Text(
                    text = when (result) {
                        is BioMetricResult.AuthenticationError -> {
                            result.errorMessage
                        }

                        BioMetricResult.AuthenticationFailed -> "Authentication Failed"
                        BioMetricResult.AuthenticationNotSet -> "Authentication Not Set"
                        BioMetricResult.AuthenticationSuccess -> "Authentication Success"
                        BioMetricResult.FeatureUnavailable -> "Feature Unavailable"
                        BioMetricResult.HardwareUnavailable -> "Hardware Unavailable"
                    }
                )*/
            }
        }
    }

}