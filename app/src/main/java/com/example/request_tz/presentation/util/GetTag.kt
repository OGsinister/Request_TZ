package com.example.request_tz.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.request_tz.R

@Composable
fun GetTag(tag: Int): ImageVector {
    when(tag){
        1 -> return ImageVector.vectorResource(id = R.drawable.ic_sale)
        2 -> return ImageVector.vectorResource(id = R.drawable.ic_hot)
        3 -> return ImageVector.vectorResource(id = R.drawable.ic_vegan)
        4 -> return ImageVector.vectorResource(id = R.drawable.ic_sale_four)
    }
    return ImageVector.vectorResource(id = R.drawable.ic_sale)
}