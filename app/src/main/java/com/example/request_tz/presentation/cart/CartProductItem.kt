package com.example.request_tz.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.R
import com.example.request_tz.domain.model.Products
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun CartProductItem(
    products: Products,
    viewModel: CatalogViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(text = products.name.toString())
                    Text(text = "32 см")
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Text(text = "count")
                    Price(products)
                }
            }
        }
        Divider(color = Color.Black.copy(alpha = 0.12f), thickness = 2.dp)
    }
}
@Composable
fun Price(products: Products){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(text = products.price_current.toString())
        products.price_old?.let {
            Text(
                text = it.toString(),
                fontSize = 14.sp,
                style = TextStyle(textDecoration = TextDecoration.LineThrough),
                color = Color.Black.copy(0.6f)
            )
        }
    }
}