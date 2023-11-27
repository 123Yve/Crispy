package com.ankit.crispy.Components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ankit.crispy.DishDetail
import com.ankit.crispy.R
import com.ankit.crispy.data.CrispyYellow
import com.ankit.crispy.data.Dishes
import kotlinx.coroutines.launch

val Dish = listOf(
        Dishes(
            1,"Greek Salad",
            "$12.99",
            "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
            R.drawable.greeksalad
        ),
    Dishes(
        2,"Bruschetta",
        "$5.99",
        "Our Bruschetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dishes(
        3,"Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    ),
    Dishes(
        4,"Greek Salad",
        "$12.99",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dishes(
        5,"Bruschetta",
        "$5.99",
        "Our Brushetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dishes(
        6,"Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    ),
    Dishes(
        7,"Greek Salad",
        "$12.99",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dishes(
        8,"Bruschetta",
        "$5.99",
        "Our Brushetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dishes(
        9,"Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    )
)
fun getDish(id: Int) = Dish.firstOrNull { it.id == id }

val Categories = listOf(
    "Lunch",
    "Dessert",
    "A La Carte",
    "Mains",
    "Specials"
)

@Composable
fun MenuScreen(navController: NavHostController) {
    Column {
        UpperScreen()
        LowerScreen(navController)
    }
}


@Composable
fun UpperScreen() {
    Box(
        Modifier.background(Color.DarkGray)
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Transparent),
            text = "Order for Takeaway", color = CrispyYellow,
            fontFamily = FontFamily(Font(R.font.teko_medium)),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun LowerScreen(navController: NavController) {
    Column {
        LazyRow() {
            items(Categories) { category ->
                MenuCategory(category)
            }
        }
        Divider(
            modifier = Modifier.padding(8.dp),
            color = Color.Gray,
            thickness = 1.dp
        )
        LazyColumn(){
            items(Dish) { dish ->
                MenuDish(dish,navController)
            }
        }
    }
}

@Composable
fun MenuCategory(category: String) {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(Color.LightGray),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = category,
            color = Color.Black
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDish(dish: Dishes,navController: NavController){
    val scope = rememberCoroutineScope()
    Card(
        onClick = {
            Log.d("JustClick","Just clicked ${dish.id}")
            navController.navigate(DishDetail.route + "/${dish.id}")
        }
    ){
        Row(
            modifier = Modifier.apply {
                fillMaxWidth()
                padding(8.dp)

            }

        ) {
            Column (

            ){
                Text(
                    text = dish.name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black
                )
                Text(
                    text = dish.description,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = dish.price, color = Color.Gray, fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = dish.image),
                contentDescription = "",
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = Color.LightGray,
        thickness = 1.dp
    )
}