package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun CategoryList(
    category: Categories,
    viewModel: CatalogViewModel
){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(
                color = if (category.id == viewModel.currentCategory.intValue)
                    mainColor
                else
                    Color.Transparent
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                viewModel.changeCategory(category.id!!)
                viewModel.getProducts()
            },
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            category.name?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    color = if(category.id == viewModel.currentCategory.intValue)
                        Color.White
                    else
                        Color.Black
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(8.dp))
}