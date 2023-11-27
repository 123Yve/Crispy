package com.ankit.crispy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val route:String
    val icon:ImageVector
    val title:String
}

object Home:Destination{
    override val route = "Home"
    override val icon = Icons.Default.Home
    override val title = "Home"
}
object Menu:Destination{
    override val route = "Menu"
    override val icon = Icons.Default.List
    override val title = "Menu"

}
object Location:Destination{
    override val route = "Location"
    override val icon = Icons.Default.LocationOn
    override val title = "Location"
}
object DishDetail:Destination{
    override val route = "Dish Detail"
    override val icon = Icons.Default.Info
    override val title = "Dish Detail"
    const val argDishID = "dishID"
}