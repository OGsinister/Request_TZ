package com.example.request_tz.presentation.splash_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.navigation.NavController
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieDynamicProperties
import com.airbnb.lottie.compose.rememberLottieDynamicProperty
import com.example.request_tz.R
import com.example.request_tz.navigation.Screens
import com.example.request_tz.ui.theme.mainColor

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.splash_screen_animation)
        )
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = 1
        )
        // меняю цвет анимации на белый, так как он выводится черным
        val dynamicProperties = rememberLottieDynamicProperties(
            rememberLottieDynamicProperty(
                property = LottieProperty.COLOR_FILTER,
                value = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.White.hashCode(),
                    BlendModeCompat.SRC_ATOP
                ),
                keyPath = arrayOf(
                    "**"
                )
            )
        )
        LaunchedEffect(key1 = progress){
            if(progress >= 1f){
                // Перехожу на экран Catalog
                navController.navigate(Screens.Catalog.route){
                    // Запрет на переход splash экрана
                    popUpTo(Screens.SplashScreen.route){
                        inclusive = true
                    }
                }
            }
        }
        LottieAnimation(
            composition = composition,
            progress = {
                progress
            },
            dynamicProperties = dynamicProperties,
            modifier = Modifier
                .size(375.dp)
        )
    }
}