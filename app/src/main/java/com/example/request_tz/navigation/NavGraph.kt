package com.example.request_tz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Catalog.route
    ) {
        composable(Screens.Catalog.route){
            // Catalog Screen
        }
        composable(Screens.CardItem.route){
            // CardItem screen
        }
        composable(Screens.Cart.route){
            // Cart screen
        }
        composable(Screens.SplashScreen.route){
            // Splash Screen
        }
    }
}
