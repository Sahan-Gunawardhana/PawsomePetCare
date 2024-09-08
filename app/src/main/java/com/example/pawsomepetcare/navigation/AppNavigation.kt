package com.example.pawsomepetcare.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.components.BottomNavBar
import com.example.pawsomepetcare.components.TopBarSettings
import com.example.pawsomepetcare.components.TopBarSettingsWithBack
import com.example.pawsomepetcare.components.TopBarSettingsWithGreeting
import com.example.pawsomepetcare.screens.CartScreen
import com.example.pawsomepetcare.screens.HomeScreen
import com.example.pawsomepetcare.screens.LandingScreen
import com.example.pawsomepetcare.screens.LoginScreen
import com.example.pawsomepetcare.screens.ProfileScreen
import com.example.pawsomepetcare.screens.SignUpScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
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

    fun shouldShowTopBarWithBack(route: String?): Boolean {
        return when (route) {
            Screens.ProductScreen.route,
            Screens.FavouritesScreen.route,
            Screens.CheckOutScreen.route -> true
            else -> false
        }
    }

    fun shouldShowTopBarWithGreeting(route: String?): Boolean {
        return route == Screens.HomeScreen.route
    }

    fun shouldShowTopBarSettings(route: String?): Boolean {
        return when (route) {
            Screens.ServicesScreen.route,
            Screens.CartScreen.route,
            Screens.ProfileScreen.route -> true
            else -> false
        }
    }

    Scaffold(

        topBar = {
            val route = navController.currentBackStackEntryAsState().value?.destination?.route
            val screenName = Screens.values()
                .find { it.route == route }
                ?.name
                ?.replace("Screen", "") ?: ""

            when {
                shouldShowTopBarWithBack(route) -> {
                    TopBarSettingsWithBack(
                        onBackArrowClick = { navController.navigate(Screens.HomeScreen.route) },
                        onSettingsClick = { /* Handle settings click */ }
                    )
                }

                shouldShowTopBarWithGreeting(route) -> {
                    TopBarSettingsWithGreeting (
                        onSettingsClick = { /* Handle settings click */ }
                    )
                }

                shouldShowTopBarSettings(route) -> {
                    TopBarSettings(
                        title = screenName,
                        onSettingsClick = { /* Handle settings click */ }
                    )
                }
                else -> null
            }
        },
        bottomBar = {
            if (shouldShowBottomBar(navController.currentBackStackEntryAsState().value?.destination?.route)) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.LandingScreen.route,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = Screens.LandingScreen.route) {
                LandingScreen(navController)
            }
            composable(route = Screens.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(route = Screens.HomeScreen.route) {
                HomeScreen(navController)
            }
            composable(route = Screens.SignUpScreen.route) {
                SignUpScreen(navController)
            }
            composable(route = Screens.ServicesScreen.route) {
            }
            composable(route = Screens.CartScreen.route) {
                CartScreen(navController)
            }
            composable(route = Screens.ProfileScreen.route) {
                ProfileScreen(navController)
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