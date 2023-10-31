package com.example.composepractice.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val label:String,
    val icon:ImageVector,
    val route:String
)

val listOfNavItems = listOf(
    NavItems(
        label = "List",
        icon = Icons.Default.List,
        route = Screens.ListScreen.name
    ),
    NavItems(
        label = "Setting",
        icon = Icons.Default.Settings,
        route = Screens.SettingScreen.name
    ),
    NavItems(
        label = "Profile",
        icon = Icons.Default.Person,
        route = Screens.ProfileScreen.name)
)