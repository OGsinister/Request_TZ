package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun Categories(
    categories: List<Categories>,
    viewModel: CatalogViewModel
){
    LazyRow{
        items(categories){
            CategoryList(category = it, viewModel)
        }
    }
}