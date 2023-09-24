package com.example.request_tz.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.request_tz.presentation.card_item.CardItemScreen
import com.example.request_tz.presentation.cart.CartScreen
import com.example.request_tz.presentation.catalog.CatalogScreen
import com.example.request_tz.presentation.search.SearchScreen
import com.example.request_tz.presentation.splash_screen.SplashScreen
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun NavGraph(
    viewModel: CatalogViewModel = hiltViewModel(),
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(Screens.Catalog.route){
            CatalogScreen(viewModel, navController = navController)
        }
        composable(
            route = "${Screens.CardItem.route}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getString("id") ?: ""
            CardItemScreen(navController,id = id, viewModel = viewModel)
        }

        composable(Screens.Cart.route){
            CartScreen(navController, viewModel)
        }

        composable(Screens.Splash.route){
            SplashScreen(navController)
        }

        composable(Screens.Search.route){
            SearchScreen(viewModel, navController)
        }
    }
}
