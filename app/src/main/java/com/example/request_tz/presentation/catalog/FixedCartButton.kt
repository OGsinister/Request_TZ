package com.example.request_tz.presentation.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.request_tz.R
import com.example.request_tz.ui.theme.mainColor

@Composable
fun FixedCartButton() {
    /**
     * navigate to Cart screen
     */
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 12.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 12.dp
                ),
            onClick = {
                /**
                 * navigate to Cart screen
                 */
            },
            colors = ButtonDefaults.buttonColors(mainColor)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = sum.floatValue.toString()
            )
        }
    }
}