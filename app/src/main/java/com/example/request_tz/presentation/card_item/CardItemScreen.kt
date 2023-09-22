package com.example.request_tz.presentation.card_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.domain.model.Products
import com.example.request_tz.navigation.Screens
import com.example.request_tz.view_models.CatalogViewModel
@Composable
fun CardItemScreen(
    navController: NavController,
    viewModel: CatalogViewModel,
    id: String
) {
    val product = viewModel.products.value.find {
        it.id == id.toInt()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
            ){
            Image(
                painter = painterResource(id = R.drawable.big_photo),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
            FloatingActionButton(
                onClick = { navController.navigate(Screens.Catalog.route) },
                containerColor = Color.White,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(5.dp),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
        if (product != null) {
            Content(product)
        }
    }
}

@Composable
fun Content(
    product: Products
){
    Row(
        modifier = Modifier
            .padding(start = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text(
            text = product.name.toString(),
            fontSize = 34.sp
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ){
        ShowName(product)
        Spacer(modifier = Modifier.padding(15.dp))
    }
    ShowDescription(product)
}

@Composable
fun ShowName(product: Products){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = product.description.toString(),
            color = Color.Black.copy(alpha = 0.6f)
        )
    }
}

// Надо зарефакторить
@Composable
fun ShowDescription(product: Products){
    val modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .height(50.dp)
        .fillMaxWidth()

    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Вес")
        Text(text = "${product.measure} ${product.measure_unit}")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Энерг. ценность")
        Text(text = "${product.energy_per_100_grams} ккал")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Белки")
        Text(text = "${product.proteins_per_100_grams} ${product.measure_unit}")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Жиры")
        Text(text = "${product.fats_per_100_grams} ${product.measure_unit}")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Углеводы")
        Text(text = "${product.carbohydrates_per_100_grams} ${product.measure_unit}")
    }
    Divider()
}