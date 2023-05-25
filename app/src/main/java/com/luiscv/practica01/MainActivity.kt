package com.luiscv.practica01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luiscv.practica01.ui.theme.Practica01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home") {
                        composable(route = "home") {
                            home(
                                /*
                                btnRegister = {
                                    //Toast.makeText(this@MainActivity, "Formulario registro", Toast.LENGTH_SHORT).show()
                                    navController.navigate("register")
                                },
                                //Otros botones
                                btnEdit = {
                                    navController.navigate("edit")
                                }*/

                            )
                        }
                    }
                }
            }
        }
    }
}