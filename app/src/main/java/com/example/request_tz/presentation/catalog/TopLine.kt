package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.navigation.Screens
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_model.MainViewModel
@Composable
fun TopLine(
    navController: NavController,
    isBottomSheetVisible: MutableState<Boolean>,
    viewModel: MainViewModel
){
    val checkedFilters = viewModel.filtersCheckedState
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Box{
            IconButton(
                onClick = {
                    isBottomSheetVisible.value = true
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = null,
                    modifier = Modifier
                )
            }
            if(checkedFilters.size != 0){
                Text(
                    text = checkedFilters.count().toString(),
                    color = Color.White,
                    fontSize = 11.sp,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 2.dp, bottom = 2.dp, start = 5.dp, end = 5.dp)
                        .drawBehind {
                            drawCircle(
                                color = mainColor,
                                radius = this.size.minDimension
                            )
                        }
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null
        )
        IconButton(onClick = { navController.navigate(Screens.Search.route) }) {
            Icon(
                modifier = Modifier
                    .padding(10.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        }
    }
}