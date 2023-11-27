package com.ankit.crispy.Components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ankit.crispy.R
import com.ankit.crispy.data.CrispyYellow
import com.ankit.crispy.data.Dishes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishDetail(id:Int) {
    val dish = requireNotNull(getDish(id))
    Log.d("CheckClick",dish.id.toString())
    var count by remember {
        mutableStateOf(0)
    }
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(dish.image),
                contentDescription = dish.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp, 250.dp)
            )
            Column(

            ) {
                Text(
                    text = dish.name,
                    fontSize = 40.sp,
                    fontFamily = FontFamily(Font(R.font.rockinsoda))
                )
                Text(text = dish.description, fontSize = 20.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = { count-- }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_remove_24),
                            contentDescription = "Remove"
                        )
                    }
                    Text(
                        text = "$count",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                    IconButton(onClick = { count++ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = "Remove"
                        )
                    }
                }
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp), colors = ButtonDefaults.buttonColors(CrispyYellow)
            ) {
                Text(text = dish.price, fontFamily = FontFamily(Font(R.font.teko_medium)))
            }
        }
    }
