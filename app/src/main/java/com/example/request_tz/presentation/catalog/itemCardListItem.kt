package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.R
import com.example.request_tz.domain.model.Products
import com.example.request_tz.ui.theme.cardBackground
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun ItemCardListItem(
    product: Products,
    viewModel: CatalogViewModel
){
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
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Text(
                text = product.name!!,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.Start),
                text = "500 гр",
                color = Color.Black.copy(alpha = 0.6f)
            )
            if(viewModel.buyCounter.intValue == 0){
                Button(
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                        /**
                         * Показать корзину
                         */
                        viewModel.isCartVisible.value = !viewModel.isCartVisible.value
                        //sum.floatValue += itemCard.priceCurrent
                        viewModel.buyCounter.intValue += 1
                    }
                ) {
                    Text(
                        text = product.price_current.toString(),
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = product.price_old.toString(),
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }else{
                Row(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Button(onClick = { viewModel.buyCounter.intValue -= 1 },
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
                    Text(text = viewModel.buyCounter.intValue.toString())
                    Button(onClick = { viewModel.buyCounter.intValue += 1 },
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