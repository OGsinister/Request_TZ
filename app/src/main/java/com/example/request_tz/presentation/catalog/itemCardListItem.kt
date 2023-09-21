package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.R
import com.example.request_tz.presentation.util.GetTag
import com.example.request_tz.ui.theme.cardBackground
import com.example.request_tz.ui.theme.mainColor

@Composable
fun ItemCardListItem(itemCard: ItemCard){
    val buyItem = remember{
        mutableIntStateOf(0)
    }

    Card(
        colors = CardDefaults.cardColors(cardBackground),
        modifier = Modifier
            .padding(top = 10.dp)
            .clickable {
                // navigate
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                modifier = Modifier
                    .height(170.dp)
                    .width(167.dp),
                painter = painterResource(id = R.drawable.photo),
                contentDescription = null
            )
            if(itemCard.tag_ids.isNotEmpty()){
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp)
                ) {
                    itemCard.tag_ids.forEach{
                        Image(
                            imageVector = GetTag(tag = it),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Text(
                text = itemCard.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.Start),
                text = "${itemCard.measure} ${itemCard.measure_unit} ",
                color = Color.Black.copy(alpha = 0.6f)
            )
            if(buyItem.intValue == 0){
                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                        /**
                         * Показать корзину
                         */
                        isCartVisible.value = !isCartVisible.value
                        //sum.floatValue += itemCard.priceCurrent
                        buyItem.intValue += 1
                    }
                ) {
                    Text(
                        text = itemCard.priceCurrent.toString(),
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    if(itemCard.priceOld != null){
                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(
                            text = itemCard.priceOld.toString(),
                            color = Color.Black,
                            fontSize = 16.sp,
                            style = TextStyle(textDecoration = TextDecoration.LineThrough)
                        )
                    }
                }
            }else{
                Row(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Button(onClick = { buyItem.intValue -= 1 },
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
                    Text(text = buyItem.intValue.toString())
                    Button(onClick = { buyItem.intValue += 1 },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(12.dp)
                    ) {
                        Icon(
                            tint = mainColor,
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_plus),
                            contentDescription = "plus"
                        )
                    }
                }
            }
        }
    }
}