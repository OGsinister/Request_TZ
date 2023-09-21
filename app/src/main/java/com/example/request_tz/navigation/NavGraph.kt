package com.example.request_tz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.request_tz.view_models.CatalogViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    viewModel: CatalogViewModel = hiltViewModel()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.CardItem.route
    ) {
        composable(Screens.Catalog.route){
            // Catalog Screen
        }
        composable(Screens.CardItem.route){
            //
        }
        composable(Screens.Cart.route){
            // Cart screen
        }
        composable(Screens.SplashScreen.route){
            // Splash Screen
        }
    }
}
