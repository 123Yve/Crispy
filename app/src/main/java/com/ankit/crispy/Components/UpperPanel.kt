package com.ankit.crispy.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ankit.crispy.Menu
import com.ankit.crispy.R

@Composable
fun UpperPanel(navController: NavController) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = TextStyle(
                letterSpacing = 2.sp,
                shadow = Shadow(
                    color = Color.White,
                    offset = Offset(8f,8f),
                    blurRadius = 4f
                )
            ),
            fontSize = 70.sp,
            color = Color(0xFFFFE400),
            fontFamily = FontFamily(Font(R.font.rockinsoda)),
            modifier = Modifier.padding(start = 10.dp, top = 10.dp).fillMaxWidth()
        )
        Text(
            text = "Pune",
            fontSize = 28.sp,
            color = Color(0xFFFFFFFF),
            fontFamily = FontFamily(Font(R.font.teko_medium)),
            modifier = Modifier.padding(start = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    Modifier
                        .width(230.dp)
                        .padding(start = 10.dp, end = 5.dp),
                    color = Color.White,
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                       navController.navigate(Menu.route)
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFE400)),
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Let's Go!",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Image(
                painterResource(id = R.drawable.gulab_jamun),
                contentDescription = "Gulab Ja mun",
                Modifier
                    .height(170.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(bottom = 10.dp, end = 5.dp)
            )
        }
    }
}
