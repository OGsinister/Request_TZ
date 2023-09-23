package com.example.request_tz.presentation.catalog

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.domain.model.Products
import com.example.request_tz.navigation.Screens
import com.example.request_tz.presentation.util.GetTag
import com.example.request_tz.presentation.util.ShowOldPrice
import com.example.request_tz.ui.theme.cardBackground
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun ItemCardListItem(
    product: Products,
    viewModel: CatalogViewModel,
    navController: NavController
){
    val counter = remember{
        mutableIntStateOf(0)
    }
    Card(
        colors = CardDefaults.cardColors(cardBackground),
        modifier = Modifier
            .padding(top = 10.dp)
            .clickable {
                navController.navigate(
                    "${Screens.CardItem.route}/${product.id}"
                )
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
            if(product.tag_ids!!.isNotEmpty()){
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp)
                ) {
                    product.tag_ids!!.forEach{
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
                text = product.name!!,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${product.measure} ${product.measure_unit}",
                color = Color.Black.copy(alpha = 0.6f)
            )

            if(counter.intValue == 0){
                AddToCart(viewModel = viewModel, product = product, counter)
            }else{
                ToCount(viewModel = viewModel, product = product, counter)
            }

            /*if(counter.intValue <= 0){
                AddToCart(viewModel = viewModel, product = product, counter)
            }else{
                ToCount(viewModel = viewModel, product = product, counter)
            }*/
        }
    }
}
@Composable
fun AddToCart(
    viewModel: CatalogViewModel,
    product: Products,
    counter: MutableIntState
){
    Button(
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RectangleShape,
        modifier = Modifier
            .padding(top = 12.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth(),
        onClick = {
            /**
             * Показать корзину
             */
            viewModel.addToCart(product)
            counter.intValue++
        }
    ) {
        Text(
            text = product.price_current.toString(),
            color = Color.Black,
            fontSize = 16.sp
        )
        ShowOldPrice(product = product)
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun ToCount(
    viewModel: CatalogViewModel,
    product: Products,
    counter: MutableIntState
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
            counter.intValue--
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
        Text(text = counter.intValue.toString())
        Button(onClick = {
            viewModel.addToCart(product)
            counter.intValue++
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