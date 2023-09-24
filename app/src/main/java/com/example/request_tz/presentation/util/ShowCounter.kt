package com.example.request_tz.presentation.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.request_tz.R
import com.example.request_tz.domain.model.Products
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun ShowCounter(
    viewModel: CatalogViewModel,
    product: Products
){
    Row(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Button(onClick = {
            viewModel.removeFromCart(product)
        },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            contentPadding = PaddingValues(12.dp)
        ) {
            Icon(
                tint = mainColor,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_minus),
                contentDescription = null
            )
        }
        Text(text = "count")
        Button(onClick = {
            viewModel.addToCart(product)
        },
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(12.dp)
        ) {
            Icon(
                tint = mainColor,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_plus),
                contentDescription = null
            )
        }
    }
}