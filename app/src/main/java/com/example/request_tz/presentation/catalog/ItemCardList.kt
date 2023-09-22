package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.request_tz.domain.model.Products
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun ItemCardList(
    category: List<Products>,
    viewModel: CatalogViewModel,
    navController: NavController
){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(category){
            ItemCardListItem(it, viewModel, navController)
        }
    }
}