package com.example.pawsomepetcare.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pawsomepetcare.ui.Common.BottomNavBar
import com.example.pawsomepetcare.ui.Common.TopBarSettings
import com.example.pawsomepetcare.ui.Common.TopBarSettingsWithBack
import com.example.pawsomepetcare.ui.Common.TopBarSettingsWithGreeting
import com.example.pawsomepetcare.ui.screens.LandingScreen
import com.example.pawsomepetcare.ui.screens.LoginScreen
import com.example.pawsomepetcare.ui.screens.ProductDetails
import com.example.pawsomepetcare.ui.screens.SignUpScreen
import com.example.pawsomepetcare.ui.screens.cartscreen.CartScreen
import com.example.pawsomepetcare.ui.screens.favouritesscreen.FavouritesScreen
import com.example.pawsomepetcare.ui.screens.homescreen.HomeScreen
import com.example.pawsomepetcare.ui.screens.profilescreen.ProfileScreen
import com.example.pawsomepetcare.ui.screens.servicesscreen.ServicesScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    fun shouldShowBottomBar(route: String?): Boolean {
        return when (route) {
            Screens.HomeScreen.route,
            Screens.ServicesScreen.route,
            Screens.CartScreen.route,
            Screens.ProductScreen.route,
            Screens.ProfileScreen.route,
            "productDetails/{productId}"-> true
            else -> false
        }
    }

    fun shouldShowTopBarWithBack(route: String?): Boolean {
        return when (route) {
            Screens.ProductScreen.route,
            Screens.FavouritesScreen.route,
            Screens.CheckOutScreen.route,
            "productDetails/{productId}"-> true
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
            val screenName = Screens.entries
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
                        navController = navController
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
            composable(route = Screens.SignUpScreen.route) {
                SignUpScreen(navController)
            }
            composable(route = Screens.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(route = Screens.HomeScreen.route, enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}) {
                HomeScreen(navController)
            }
            composable(route = Screens.ServicesScreen.route, enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}) {
                ServicesScreen(navController)
            }
            composable(route = Screens.CartScreen.route, enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}) {
                CartScreen(navController)
            }
            composable(route = Screens.ProfileScreen.route, enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}) {
                ProfileScreen(navController)
            }
            composable(route = Screens.FavouritesScreen.route, enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}) {
                FavouritesScreen(navController)
            }
            composable(
                route = "productDetails/{productId}",enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(10) )},arguments = listOf(navArgument("productId"){type = NavType.StringType} )
            ){
               navBackStackEntry -> val productId = navBackStackEntry.arguments?.getString("productId")?:""
               ProductDetails(productId = productId, navController = navController)
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