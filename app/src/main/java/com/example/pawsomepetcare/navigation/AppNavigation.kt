package com.example.pawsomepetcare.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.screens.HomeScreen
import com.example.pawsomepetcare.screens.LandingScreen
import com.example.pawsomepetcare.screens.LoginScreen
import com.example.pawsomepetcare.screens.SignUpScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pawsomepetcare.components.BottomBarNavItem
import com.example.pawsomepetcare.components.BottomNavBar
import com.example.pawsomepetcare.components.listOfNavItems

@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    fun shouldShowBottomBar(route: String?): Boolean {
        return when (route) {
            Screens.HomeScreen.route,
            Screens.ServicesScreen.route,
            Screens.CartScreen.route,
            Screens.ProfileScreen.route -> true
            else -> false
        }
    }
    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar(navController.currentBackStackEntryAsState().value?.destination?.route)) {
                BottomNavBar(navController = navController)
            }
        }
    ) {
        paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.LandingScreen.route,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = Screens.LandingScreen.route){
                LandingScreen(navController)
            }
            composable(route = Screens.LoginScreen.route){
                LoginScreen(navController)
            }
            composable(route = Screens.HomeScreen.route){
                HomeScreen(navController)
            }
            composable(route = Screens.SignUpScreen.route) {
                SignUpScreen(navController)
            }
            composable(route = Screens.ServicesScreen.route){

            }
            composable(route = Screens.CartScreen.route){

            }
            composable(route = Screens.ProfileScreen.route){

            }
        }
    }

}

//
//NavHost(navController = navController, startDestination = "landing"){
//    composable("Landing"){
//        LandingScreen(navController,modifier)
//    }
//    composable("Login"){
//        LoginScreen(navController,modifier)
//    }
//    composable("SignUp"){
//        SignUpScreen(navController,modifier)
//    }
//    composable("Home"){
//        HomeScreen(navController,modifier)
//    }
//}