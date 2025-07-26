package com.tax.visa.uiintroduction.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tax.visa.uiintroduction.HomeScreen
import com.tax.visa.uiintroduction.screens.LazyColumn
import com.tax.visa.uiintroduction.screens.LazyGrid
import com.tax.visa.uiintroduction.screens.LazyRow
import com.tax.visa.uiintroduction.screens.NetworkImage

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("lazy_column") { LazyColumn() }
        composable("lazy_row") { LazyRow() }
        composable("lazy_grid") { LazyGrid() }
        composable("network_image") { NetworkImage() }
    }
}