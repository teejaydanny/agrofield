package com.example.agrofield.ui.theme.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agrofield.navigation.ROUTE_HOME

@Composable
fun AboutScreen(navController: NavController) {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "About Screen",
                modifier = Modifier.padding(vertical = 16.dp),
                style = MaterialTheme.typography.h4
            )

            Text(
                text = "This app is meant to help farmers to reach out to the market and sell their products.",
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp),
                style = MaterialTheme.typography.body1
            )

            Button(
                onClick = { navController.navigate(ROUTE_HOME) },
                modifier = Modifier.padding(vertical = 16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Back to Home",
                    style = MaterialTheme.typography.button,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutScreenPreview() {
    val navController = rememberNavController()
    AboutScreen(navController = navController)
}
