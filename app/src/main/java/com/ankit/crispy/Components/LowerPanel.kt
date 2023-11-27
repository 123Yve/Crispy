package com.ankit.crispy.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ankit.crispy.R
import com.ankit.crispy.data.Dishes



@Composable
fun LowerPanel(navController: NavHostController){
    Column {
        WeekendSpecialCard()
        MenuDish(navController)
    }
}

@Composable
fun WeekendSpecialCard() {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.DarkGray),
        contentAlignment = Alignment.Center,

    ) {
        Text(
            text = "Weekend Special",
            fontFamily = FontFamily(Font(R.font.teko_medium)),
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp),
            color = Color.White
        )
    }
}

@Composable
fun MenuDish(navController: NavHostController) {
    LazyColumn(){
        items(Dish) { dish ->
            MenuDish(dish,navController)
        }
    }
}