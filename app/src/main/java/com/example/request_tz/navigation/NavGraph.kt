package com.example.request_tz.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.request_tz.presentation.card_item.CardItemScreen
import com.example.request_tz.presentation.cart.CartScreen
import com.example.request_tz.presentation.catalog.CatalogScreen
import com.example.request_tz.presentation.splash_screen.SplashScreen
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    viewModel: CatalogViewModel = hiltViewModel()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(Screens.Catalog.route){
            CatalogScreen(viewModel)
        }
        composable(Screens.CardItem.route){
            CardItemScreen()
        }
        composable(Screens.Cart.route){
            CartScreen()
        }
        composable(Screens.SplashScreen.route){
            SplashScreen(navHostController)
        }
    }
}
