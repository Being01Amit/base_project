package com.android.roompractice.Views.UI

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navController: NavHostController?
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ItemBox()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen(null)
}

@Composable
fun ItemBox() {
    Box(
        modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
    ) {}
}