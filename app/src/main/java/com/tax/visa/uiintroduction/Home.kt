package com.tax.visa.uiintroduction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController

    ) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {navController.navigate("lazy_row")}) {
            Text("Lazy Row View")
        }
        Spacer(modifier.height(30.dp))

        Button(onClick = {navController.navigate("lazy_column")}) {
            Text("Lazy Column View")
        }
        Spacer(modifier.height(30.dp))

        Button(onClick = {navController.navigate("lazy_grid")}) {
            Text("Lazy Grid View")
        }
        Spacer(modifier.height(30.dp))

        Button(onClick = {navController.navigate("network_image")}) {
            Text("Network Image")
        }
        Spacer(modifier.height(30.dp))


    }
}