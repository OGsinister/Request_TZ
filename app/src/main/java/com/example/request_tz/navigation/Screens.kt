package com.example.request_tz.navigation

sealed class Screens(val route: String){
    object Catalog: Screens(route = "catalog")
    object CardItem: Screens(route = "cardItem")
    object Cart: Screens(route = "cart")
    object Splash: Screens(route = "splash")
    object Search: Screens(route = "search")
}
