package com.example.request_tz.presentation.util

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.domain.model.Products
@Composable
fun ShowOldPrice(product: Products) {
    if(product.price_old != null){
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "${product.price_old} ${Symbols.ruble}",
            color = Color.Black.copy(alpha = 0.6f),
            fontSize = 12.sp,
            style = TextStyle(textDecoration = TextDecoration.LineThrough),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}