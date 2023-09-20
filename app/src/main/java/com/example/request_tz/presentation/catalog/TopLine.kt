package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.request_tz.R

@Composable
fun TopLine(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(
            onClick = {
                /**
                 * navigate to filters screen
                 */
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = null
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .padding(10.dp),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null
        )
    }
}