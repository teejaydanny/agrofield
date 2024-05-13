package com.example.agrofield.ui.theme.screens.Products

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agrofield.R
import com.example.agrofield.data.ProductViewModel
import com.example.agrofield.navigation.ROUTE_VIEW_PRODUCT
import com.example.agrofield.navigation.ROUTE_VIEW_UPLOAD


@Composable
fun AddProductsScreen(navController: NavHostController) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.autumn), // Replace with your background image
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.8f, // Adjust the alpha as needed for the background image
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add Product",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.White, // Text color set to white
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )

            var productName by remember { mutableStateOf(TextFieldValue("")) }
            var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
            var productPrice by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                value = productName,
                onValueChange = { productName = it },
                label = { Text(text = "Product name *") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = productQuantity,
                onValueChange = { productQuantity = it },
                label = { Text(text = "Product quantity *") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = productPrice,
                onValueChange = { productPrice = it },
                label = { Text(text = "Product price *") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                val productRepository = ProductViewModel(navController, context)
                productRepository.saveProduct(
                    productName.text.trim(), productQuantity.text.trim(),
                    productPrice.text
                )
                navController.navigate(ROUTE_VIEW_PRODUCT)
            }) {
                Text(text = "Save")
            }

            Spacer(modifier = Modifier.height(20.dp))

            ImagePicker(Modifier, context, navController, productName.text.trim(), productQuantity.text.trim(), productPrice.text.trim())
        }
    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, quantity:String, price:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                val productRepository = ProductViewModel(navController, context)
                productRepository.saveProductWithImage(name, quantity, price, imageUri!!)
                navController.navigate(ROUTE_VIEW_UPLOAD)

            }) {
                Text(text = "Upload")
            }
            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//

                navController.navigate(ROUTE_VIEW_UPLOAD)

            }) {
                Text(text = "view uploads")
            }

        }
    }
}

@Preview
@Composable
fun AddProductsScreenPreview() {
    AddProductsScreen(rememberNavController())
}
