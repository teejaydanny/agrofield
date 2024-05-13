
package com.example.agrofield.data

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.agrofield.navigation.ROUTE_HOME
import com.example.agrofield.navigation.ROUTE_LOGIN
import com.example.agrofield.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(private val navController: NavController, private val context: Context) : ViewModel() {
    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signup(email: String, password: String, confirmPassword: String) {
        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(context, "Email and password cannot be blank", Toast.LENGTH_LONG).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                FirebaseDatabase.getInstance().getReference("Users/${mAuth.currentUser?.uid}")
                    .setValue(email)
                    .addOnCompleteListener { registrationTask ->
                        if (registrationTask.isSuccessful) {
                            Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_HOME)
                        } else {
                            val errorMessage = registrationTask.exception?.message ?: "Unknown error occurred"
                            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_REGISTER)
                        }
                    }
            } else {
                val errorMessage = task.exception?.message ?: "Unknown error occurred"
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Successfully Logged in", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
            } else {
                val errorMessage = task.exception?.message ?: "Unknown error occurred"
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }
    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

//    fun isLoggedIn(): Boolean {
//        return mAuth.currentUser != null
//    }

    fun isloggedin(): Boolean {
        return mAuth.currentUser != null
    }
}
