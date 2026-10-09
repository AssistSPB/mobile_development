package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4.ui.theme.Lab4Theme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.annotation.DrawableRes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab4Theme {
                Lab4App()
            }
        }
    }
}

@Composable
fun Lab4App() {

    var page by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = page == 0,
                    onClick = { page = 0 },
                    icon = { Text("1") },
                    label = {
                        Text(stringResource(R.string.nav_article))
                    }
                )

                NavigationBarItem(
                    selected = page == 1,
                    onClick = { page = 1 },
                    icon = { Text("2") },
                    label = {
                        Text(stringResource(R.string.nav_tasks))
                    }
                )

                NavigationBarItem(
                    selected = page == 2,
                    onClick = { page = 2 },
                    icon = { Text("3") },
                    label = {
                        Text(stringResource(R.string.nav_quadrant))
                    }
                )

                NavigationBarItem(
                    selected = page == 3,
                    onClick = { page = 3 },
                    icon = { Text("4") },
                    label = {
                        Text(stringResource(R.string.nav_me))
                    }
                )
            }
        }

    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when (page) {
                0 -> ComposeArticleScreen()
                1 -> TaskManagerScreen()
                2 -> ComposeQuadrantScreen()
                3 -> MyInformationScreen()
            }
        }
    }
}

@Composable
fun ComposeArticleScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(R.drawable.compose_article),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        Text(
            text = stringResource(R.string.article_title),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = stringResource(R.string.article_text_1),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )

        Text(
            text = stringResource(R.string.article_text_2),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun TaskManagerScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.task_completed),
            contentDescription = null,
            modifier = Modifier.size(160.dp)
        )

        Text(
            text = stringResource(R.string.tasks_completed),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 8.dp
            )
        )

        Text(
            text = stringResource(R.string.nice_work),
            fontSize = 16.sp
        )
    }
}

@Composable
fun ComposeQuadrantScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier.weight(1f)
        ) {

            Quadrant(
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.text_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )

            Quadrant(
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.image_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.weight(1f)
        ) {

            Quadrant(
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.row_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )

            Quadrant(
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.column_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun MyInformationScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(R.drawable.profile_photo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(4.dp))
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp)
                )
        )

        Text(
            text = stringResource(R.string.full_name),
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 14.dp)
        )

        Text(
            text = stringResource(R.string.person_title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        InformationRow(
            iconRes = R.drawable.phone_icon,
            text = stringResource(R.string.phone)
        )

        InformationRow(
            iconRes = R.drawable.social_icon,
            text = stringResource(R.string.social)
        )

        InformationRow(
            iconRes = R.drawable.email_icon,
            text = stringResource(R.string.email)
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )
    }
}


@Composable
fun InformationRow(
    @DrawableRes iconRes: Int,
    text: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(30.dp)
        )

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Text(
            text = text,
            fontSize = 17.sp,
            modifier = Modifier.width(220.dp)
        )
    }
}