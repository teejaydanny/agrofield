package com.example.agrofield.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agrofield.R
import com.example.agrofield.data.AuthViewModel
import com.example.agrofield.navigation.ROUTE_HOME
import com.example.agrofield.navigation.ROUTE_LOGIN
import com.example.agrofield.navigation.ROUTE_REGISTER

@Composable
fun LoginScreen(navController: NavHostController) {


    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.autumn
            ), contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login here",
                color = Color.Magenta,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Light,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter Email") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text(text = "Enter password") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_HOME)
                    val mylogin = AuthViewModel(navController,context)
                    mylogin.login(email.text.trim(), pass.text.trim())      },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Log In")
            }


            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate(ROUTE_REGISTER) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Don't have an account? Click to Register")

            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
