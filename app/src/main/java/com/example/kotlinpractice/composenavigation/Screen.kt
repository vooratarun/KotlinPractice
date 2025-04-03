package com.example.kotlinpractice.composenavigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Profile : Screen("profile", "Profile")
}
