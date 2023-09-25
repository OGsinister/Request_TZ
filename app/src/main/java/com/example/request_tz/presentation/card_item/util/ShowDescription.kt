package com.example.request_tz.presentation.card_item.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.request_tz.R
import com.example.request_tz.domain.model.Products
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
        Text(text = stringResource(id = R.string.weight))
        Text(text = "${product.measure} ${product.measure_unit}")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(id = R.string.energy_value))
        Text(text = "${product.energy_per_100_grams} ${stringResource(id = R.string.kcal)}")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(id = R.string.proteins))
        Text(text = "${product.proteins_per_100_grams} ${product.measure_unit}")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(id = R.string.fats))
        Text(text = "${product.fats_per_100_grams} ${product.measure_unit}")
    }
    Divider()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(id = R.string.carbohydrates))
        Text(text = "${product.carbohydrates_per_100_grams} ${product.measure_unit}")
    }
    Divider()
}