package com.example.kotlinpractice.composenavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.*


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
//            BottomNavigation {
//                BottomNavigationItem(
//                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//                    label = { Text("Home") },
//                    selected = false,
//                    onClick = { navController.navigate(Screen.Home.route) }
//                )
//                BottomNavigationItem(
//                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
//                    label = { Text("Profile") },
//                    selected = false,
//                    onClick = { navController.navigate(Screen.Profile.route) }
//                )
//            }
        }
    ) { padding ->
        NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(padding)) {
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}
