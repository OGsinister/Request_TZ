package com.example.request_tz.presentation.search.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.request_tz.R
import com.example.request_tz.navigation.Screens
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_models.CatalogViewModel

@Composable
fun Header(
    navController: NavController,
    viewModel: CatalogViewModel
) {
    val searchText = viewModel.searchText.collectAsState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            SearchBar(viewModel,searchText, navController)
        }
    }
}

@Composable
fun SearchBar(
    viewModel: CatalogViewModel,
    searchText: State<String>,
    navController: NavController
){
    TextField(
        value = searchText.value,
        onValueChange = viewModel::onSearchTextChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.default_search_text),
                fontSize = 16.sp,
                color = Color.Black.copy(alpha = 0.6f)
            )
        },
        leadingIcon = {
            IconButton(
                onClick = { navController.navigate(Screens.Catalog.route) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = null,
                    tint = mainColor
                )
            }
        },
        trailingIcon = {
            if(searchText.value.isNotBlank()){
                IconButton(onClick = {viewModel.onSearchTextChange("")}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cancel),
                        contentDescription = null
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}