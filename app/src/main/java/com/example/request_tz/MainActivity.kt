package com.example.request_tz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.request_tz.navigation.NavGraph
import com.example.request_tz.ui.theme.Request_TZTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Request_TZTheme {
                navHostController = rememberNavController()
                NavGraph(navHostController = navHostController)
            }
        }
    }
}