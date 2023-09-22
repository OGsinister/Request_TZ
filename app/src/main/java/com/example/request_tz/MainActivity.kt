package com.example.request_tz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.request_tz.navigation.NavGraph
import com.example.request_tz.ui.theme.Request_TZTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Request_TZTheme {
                val navHostController = rememberNavController()
                NavGraph(
                    navController = navHostController
                )
            }
        }
    }
}