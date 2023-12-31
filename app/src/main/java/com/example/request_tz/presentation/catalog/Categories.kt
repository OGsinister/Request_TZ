package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.view_model.MainViewModel
@Composable
fun Categories(
    categories: List<Categories>,
    viewModel: MainViewModel
){
    LazyRow{
        items(categories){
            CategoryList(category = it, viewModel)
        }
    }
}