package com.example.request_tz.presentation.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.navigation.Screens
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun CartScreen(
    navController: NavController,
    viewModel: CatalogViewModel
) {
    val clientOrder = viewModel.order
    
    Column(modifier = Modifier.fillMaxSize()) {
        Header(navController = navController)
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
}
@Composable
fun Header(
    navController: NavController
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = { navController.navigate(Screens.Catalog.route) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = null,
                    tint = mainColor
                )
            }
            Text(
                text = stringResource(id = R.string.cart),
                fontSize = 18.sp,
                color = Color.Black.copy(0.87f)
            )
        }
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