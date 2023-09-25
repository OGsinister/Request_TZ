package com.example.request_tz.presentation.catalog

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.presentation.bottom_sheet.ModalBottomSheet
import com.example.request_tz.presentation.bottom_sheet.NotFoundFiltersProducts
import com.example.request_tz.view_model.MainViewModel
@Composable
fun CatalogScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val categories = viewModel.categories
    val context = LocalContext.current
    val products = viewModel.products
    val isBottomSheetVisible = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 0.dp
                )
                .weight(1f)
        ) {
            TopLine(navController, isBottomSheetVisible, viewModel)
            Categories(categories.value, viewModel)

            AnimatedVisibility(
                visible = viewModel.filtersCheckedState.isNotEmpty() && viewModel.products.value.isEmpty()
            ) {
                NotFoundFiltersProducts()
            }
            ItemCardList(products.value, viewModel, navController)
        }

        if(isBottomSheetVisible.value){
            ModalBottomSheet(isBottomSheetVisible, viewModel)
        }

        AnimatedVisibility(
            visible = viewModel.totalPrice.intValue != 0,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            FixedCartButton(viewModel, navController)
        }

        if(viewModel.bought.value){
            Toast.makeText(context, stringResource(id = R.string.ToastBought), Toast.LENGTH_SHORT).show()
            viewModel.bought.value = false
        }
    }
}