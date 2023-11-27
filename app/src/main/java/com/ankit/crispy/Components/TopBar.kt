package com.ankit.crispy.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ankit.crispy.R
import com.ankit.crispy.data.CrispyYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.crispylogo),
                    contentDescription = "",
                    Modifier.size(width = 40.dp, height = 40.dp)
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 35.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    fontFamily = FontFamily(Font(R.font.rockinsoda)),
                    color = Color(0xFFFFE400)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                navIconClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open Drawer",
                    tint = CrispyYellow
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.DarkGray)
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {

}