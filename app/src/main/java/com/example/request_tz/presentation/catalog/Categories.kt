package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun Categories(){
    LazyRow{
        items(tabItems){
            CategoryList(category = it)
        }
    }
}