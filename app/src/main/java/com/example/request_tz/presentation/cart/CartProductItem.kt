package com.example.request_tz.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.R
import com.example.request_tz.ui.theme.cartButtonColor
import com.example.request_tz.ui.theme.mainColor
@Composable
fun CartProductItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
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
                    Text(text = "Том ям")
                    Text(text = "32 см")
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Counter()
                    Price()
                }
            }
        }
        Divider(color = Color.Black.copy(alpha = 0.12f), thickness = 2.dp)
    }
}
@Composable
fun Counter(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(onClick = {
            //viewModel.removeFromCart(product)
            //counter.intValue--
        },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(cartButtonColor),
            contentPadding = PaddingValues(12.dp)
        ) {
            Icon(
                tint = mainColor,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_minus),
                contentDescription = null
            )
        }
        //Text(text = counter.intValue.toString())
        Text(text = "1")
        Button(onClick = {
            //viewModel.addToCart(product)
            //counter.intValue++
        },
            colors = ButtonDefaults.buttonColors(cartButtonColor),
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

@Composable
fun Price(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "520")
        Text(
            text = "600",
            fontSize = 14.sp,
            style = TextStyle(textDecoration = TextDecoration.LineThrough),
            color = Color.Black.copy(0.6f)
        )
    }
}