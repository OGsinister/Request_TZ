package com.example.request_tz.presentation.card_item.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.domain.model.Products
import com.example.request_tz.navigation.Screens
import com.example.request_tz.presentation.util.Symbols
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_model.MainViewModel
@Composable
fun ToCartButton(
    navController: NavController,
    product: Products?,
    viewModel: MainViewModel
){
    Button(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 12.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 12.dp
            ),
        onClick = {
            navController.navigate(Screens.Catalog.route)
            viewModel.addToCart(product!!)
        },
        colors = ButtonDefaults.buttonColors(mainColor)
    ) {
        Text(
            text = stringResource(id = R.string.Order_for_price),
            modifier = Modifier.padding(end = 10.dp),
            color = Color.White
        )
        Text(
            text = "${product?.price_current} ${Symbols.ruble}",
            modifier = Modifier.padding(end = 2.dp),
            color = Color.White
        )
    }
}