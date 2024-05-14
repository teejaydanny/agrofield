package com.example.agrofield.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.agrofield.ui.theme.screens.login.LoginScreen
import com.example.agrofield.ui.theme.screens.about.AboutScreen
import com.example.agrofield.ui.theme.screens.home.HomeScreen
import com.example.agrofield.ui.theme.screens.register.RegisterScreen
import com.example.agrofield.ui.theme.screens.splashscreen.SplashScreen
import com.example.agrofield.ui.theme.screens.Products.AddProductsScreen
import com.example.agrofield.ui.theme.screens.Products.ViewUploadsScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = ROUTE_SPLASHSCREEN) {
        composable(ROUTE_SPLASHSCREEN) {
            SplashScreen(navController = navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController = navController)
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductsScreen(navController = navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(navController = navController)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }
   
    }
}
