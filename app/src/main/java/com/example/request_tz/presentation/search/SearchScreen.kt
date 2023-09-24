package com.example.request_tz.presentation.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.request_tz.presentation.catalog.ItemCardListItem
import com.example.request_tz.presentation.search.utils.Header
import com.example.request_tz.presentation.search.utils.NotFoundScreen
import com.example.request_tz.presentation.search.utils.StartScreen
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun SearchScreen(
    viewModel: CatalogViewModel,
    navController: NavController
) {
    val searchText = viewModel.searchText.collectAsState()
    val products = viewModel.foundedProducts.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){
        Header(navController = navController, viewModel = viewModel)

        AnimatedVisibility(visible = searchText.value.isBlank()) {
            StartScreen()
        }
        AnimatedVisibility(
            visible = searchText.value.isNotBlank() && products.value.isNotEmpty(),
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(products.value){
                    ItemCardListItem(it, viewModel, navController)
                }
            }
        }

        AnimatedVisibility(
            visible = products.value.isEmpty(),
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            NotFoundScreen()
        }
    }
}