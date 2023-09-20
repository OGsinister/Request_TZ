package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.R
import com.example.request_tz.ui.theme.cardBackground

@Composable
fun ItemCardListItem(itemCard: ItemCard){
    Card(
        colors = CardDefaults.cardColors(cardBackground),
        modifier = Modifier
            .padding(top = 10.dp)
            .clickable {
                // navigate
            }
    ) {
        Image(
            modifier = Modifier
                .height(170.dp)
                .width(167.dp),
            painter = painterResource(id = R.drawable.photo),
            contentDescription = null
        )
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = itemCard.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.Start),
                text = "500 гр",
                color = Color.Black.copy(alpha = 0.6f)
            )
            Button(
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RectangleShape,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    /**
                     * Показать корзину
                     */
                    isCartVisible.value = !isCartVisible.value
                    sum.floatValue += itemCard.priceCurrent
                }
            ) {
                Text(
                    text = itemCard.priceCurrent.toString(),
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Text(
                    text = itemCard.priceOld.toString(),
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
        }
    }
}