package com.example.request_tz.presentation.catalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel,
    modifier: Modifier = Modifier
) {
    val categories = viewModel.categories
    val products = viewModel.products
    val isCartVisible = viewModel.isCartVisible

    // Load models
    viewModel.getCategories()
    viewModel.getTags()
    viewModel.getProducts()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 0.dp
                )
                .weight(1f)
        ) {
            TopLine()
            Categories(categories.value, viewModel)
            ItemCardList(products.value, viewModel)
        }
        AnimatedVisibility(
            visible = isCartVisible.value,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            FixedCartButton(viewModel)
        }
    }
}