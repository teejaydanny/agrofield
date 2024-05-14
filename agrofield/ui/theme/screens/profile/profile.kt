package com.example.agrofield.ui.theme.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.agrofield.R

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfilePicture()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileInfo("User Name", "Email Address")
        Spacer(modifier = Modifier.height(32.dp))
        LogoutButton(navController)
    }
}

@Composable
fun ProfilePicture() {
    Box(
        modifier = Modifier
            .size(150.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.autumn), // Placeholder image
            contentDescription = "Profile Picture",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ProfileInfo(userName: String, emailAddress: String) {
    Text(text = "User Name: $userName")
    Text(text = "Email Address: $emailAddress")
}

@Composable
fun LogoutButton(navController: NavHostController) {
    Button(onClick = {
        navController.navigate("login")
    }) {
        Text("Logout")
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = NavHostController(LocalContext.current))
}
