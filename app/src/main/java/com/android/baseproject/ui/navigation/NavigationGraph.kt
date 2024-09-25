package com.android.baseproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.baseproject.ui.views.animelist.AnimeListScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoutes.ScreenAnimeList) {
        composable<NavigationRoutes.ScreenAnimeList> {
            AnimeListScreen()
        }

    }
}