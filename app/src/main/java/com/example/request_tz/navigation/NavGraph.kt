package com.example.request_tz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.request_tz.presentation.card_item.CardItemScreen
import com.example.request_tz.presentation.cart.CartScreen
import com.example.request_tz.presentation.catalog.CatalogScreen
import com.example.request_tz.presentation.splash_screen.SplashScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Catalog.route
    ) {
        composable(Screens.Catalog.route){
            CatalogScreen()
        }
        composable(Screens.CardItem.route){
            CardItemScreen()
        }
        composable(Screens.Cart.route){
            CartScreen()
        }
        composable(Screens.SplashScreen.route){
            SplashScreen()
        }
    }
}
