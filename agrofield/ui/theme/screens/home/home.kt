package com.example.agrofield.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agrofield.R
import com.example.agrofield.navigation.ROUTE_ABOUT
import com.example.agrofield.navigation.ROUTE_ADD_PRODUCT
import com.example.agrofield.navigation.ROUTE_PROFILE
import com.example.agrofield.navigation.ROUTE_VIEW_PRODUCT
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.autumn),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Home page",
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.navigate(ROUTE_ADD_PRODUCT)
            }) {
                Text(text = "Add cashcrops")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.navigate(ROUTE_VIEW_PRODUCT)
            }) {
                Text(text = "View crop products")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    TopAppBar(
        title = {
            Text(text = "Agrofield")
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(ROUTE_PROFILE)
            }) {
                Icon(Icons.Default.Person, contentDescription = "Profile")
            }
            IconButton(onClick = {
                navController.navigate(ROUTE_ABOUT)
            }) {
                Icon(Icons.Default.Info, contentDescription = "About")
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}
