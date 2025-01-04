package com.android.roompractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.roompractice.App.Companion.firebaseInstance
import com.android.roompractice.Views.UI.HomeScreen
import com.android.roompractice.Views.navigation.Navigation.HOME_SCREEN_NAVIGATION
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*firebaseInstance.token.addOnCompleteListener { token ->
            Log.d("TAG----->", "intent ${token.result}")

        }.addOnFailureListener{

        }*/

        setContent {
            NavigationComponent()
        }
    }
}

@Composable
fun NavigationComponent(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME_SCREEN_NAVIGATION ){
        composable(HOME_SCREEN_NAVIGATION){
            HomeScreen(navController)
        }
    }
}