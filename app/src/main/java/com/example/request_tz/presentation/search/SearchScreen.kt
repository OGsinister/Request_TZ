package com.example.request_tz.presentation.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.request_tz.presentation.search.utils.Header
import com.example.request_tz.presentation.search.utils.NotFoundScreen
import com.example.request_tz.presentation.search.utils.StartScreen
import com.example.request_tz.presentation.util.GetTag
import com.example.request_tz.presentation.util.ShowOldPrice
import com.example.request_tz.presentation.util.Symbols
import com.example.request_tz.ui.theme.cardBackground
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_model.MainViewModel
@Composable
fun SearchScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
    val searchText = viewModel.searchText.collectAsState()
    val products = viewModel.foundedProducts.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){
        Header(navController = navController, viewModel = viewModel)

        AnimatedVisibility(visible = searchText.value.isBlank()) {
            StartScreen()
        }
        AnimatedVisibility(
            visible = searchText.value.isNotBlank() && products.value.isNotEmpty(),
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(products.value){
                    SearchItemCardListItem(navController, it, viewModel)
                }
            }
        }

        AnimatedVisibility(
            visible = products.value.isEmpty(),
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            NotFoundScreen()
        }
    }
}

@Composable
fun SearchItemCardListItem(
    navController: NavController,
    product: Products,
    viewModel: MainViewModel
){
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
                text = product.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${product.measure} ${product.measure_unit}",
                color = Color.Black.copy(alpha = 0.6f)
            )
            if(product.quantity == 0){
                SearchAddToCart(viewModel = viewModel, product = product)
            }else{
                SearchShowCounter(viewModel, product)
            }
        }
    }
}
@Composable
fun SearchAddToCart(viewModel: MainViewModel, product: Products){
    Button(
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RectangleShape,
        modifier = Modifier
            .padding(top = 12.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth(),
        onClick = {
            viewModel.addToCart(product)
        }
    ) {
        Text(
            text = "${product.price_current} ${Symbols.ruble}",
            color = Color.Black,
            fontSize = 16.sp
        )
        ShowOldPrice(product = product)
    }
}

@Composable
fun SearchShowCounter(viewModel: MainViewModel, product: Products){
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
        Text(text = product.quantity.toString())
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