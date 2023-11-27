package com.ankit.crispy.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ankit.crispy.Components.DishDetail
import com.ankit.crispy.Components.HomeScreen
import com.ankit.crispy.Components.LocationScreen
import com.ankit.crispy.Components.MenuScreen
import com.ankit.crispy.Components.TopBar
import com.ankit.crispy.Destination
import com.ankit.crispy.DishDetail
import com.ankit.crispy.Home
import com.ankit.crispy.Location
import com.ankit.crispy.Menu
import com.ankit.crispy.R
import com.ankit.crispy.data.CrispyYellow
import com.ankit.crispy.data.Dishes
import com.ankit.crispy.data.DrawerContent
import com.ankit.crispy.ui.theme.CrispyTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrispyTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun MyNavigationBar(navController: NavHostController) {
    val destinationList = listOf<Destination>(Home, Menu, Location)
    val selectedIndex = rememberSaveable() {
        mutableStateOf(0)
    }
    BottomNavigation(
        backgroundColor = Color.DarkGray
    ) {
        destinationList.forEachIndexed { index, destination ->
            BottomNavigationItem(
                label = { Text(text = destination.title, color = CrispyYellow) },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destination.route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        tint = CrispyYellow,
                        contentDescription = destination.title
                    )
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    val navController = rememberNavController()
    val item = listOf(
        DrawerContent(
            title = "Home",
            icon = Icons.Default.Home
        ),
        DrawerContent(
            title = "Help",
            icon = Icons.Default.Call
        ),
        DrawerContent(
            title = "About Us",
            icon = Icons.Default.Info
        )
    )
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .size(height = 150.dp, width = 0.dp),
                    Alignment.CenterStart
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontFamily = FontFamily(Font(R.font.rockinsoda)),
                        fontSize = 50.sp,
                        color = Color(0xFFFFE400),
                    )
                }
                item.forEachIndexed { index, list ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = list.title)
                        },
                        selected = false,
                        onClick = {
                            Toast.makeText(context, "${list.title} Clicked", Toast.LENGTH_SHORT)
                                .show()
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(imageVector = list.icon, contentDescription = "")
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    navIconClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                MyNavigationBar(navController = navController)
            }
        ) { it ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Home.route) {
                        HomeScreen(navController)
                    }
                    composable(Menu.route) {
                        MenuScreen(navController)
                    }
                    composable(Location.route) {
                        LocationScreen()
                    }
                    composable(
                        DishDetail.route + "/{${DishDetail.argDishID}}",
                        arguments = listOf(navArgument(DishDetail.argDishID) {
                            type = NavType.IntType
                        })
                    ) {
                        val id = requireNotNull(it.arguments?.getInt(DishDetail.argDishID)) { "Dish id is null" }
                        DishDetail(id)
                    }
                }
            }
        }
    }
}

