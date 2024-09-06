package com.example.pawsomepetcare.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing"){
        composable("Landing"){
            LandingScreen(navController,modifier)
        }
        composable("Login"){
            LoginScreen(navController,modifier)
        }
        composable("SignUp"){
            SignUpScreen(navController,modifier)
        }
        composable("Home"){
            HomeScreen(navController,modifier)
        }
    }
}

