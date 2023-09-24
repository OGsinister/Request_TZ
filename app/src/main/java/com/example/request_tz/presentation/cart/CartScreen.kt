package com.example.request_tz.presentation.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun CartScreen(
    navController: NavController,
    viewModel: CatalogViewModel
) {
    val clientOrder = viewModel.order
    if(viewModel.totalSum.intValue != 0){
        LazyColumn{
            items(clientOrder.value){
                CartProductItem(it, viewModel)
            }
        }
    }else{
        EmptyCartScreen()
    }
}

@Composable
fun EmptyCartScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.empty_cart),
            fontSize = 16.sp,
            modifier = Modifier
                .width(240.dp),
            color = Color.Black.copy(alpha = 0.6f)
        )
    }
}