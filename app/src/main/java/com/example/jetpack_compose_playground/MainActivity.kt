package com.example.jetpack_compose_playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_compose_playground.data.CarModel
import com.example.jetpack_compose_playground.ui.Jetpack_compose_playgroundTheme
import com.example.jetpack_compose_playground.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.carData.observe(this, { carData ->
            setContent {
                MyApp {
                    MainScreen(carData)
                }
            }
        })
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Jetpack_compose_playgroundTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun MainScreen(carData: CarModel) {

    ScrollableColumn() {
        Stack {
            Surface(
                shape = RoundedCornerShape(bottomLeft = 16.dp, bottomRight = 16.dp),
            ) {
                Image(
                    asset = imageResource(id = carData.image),
                    modifier = Modifier.preferredHeightIn(160.dp, 260.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )
            }
            Text(
                text = carData.name,
                color = Color.White,
                style = TextStyle(
                    color = Color.White,
                    fontSize = TextUnit.Companion.Sp(24),
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    .gravity(Alignment.BottomEnd)
            )

        }
        CarDescription(carData = carData)
    }
}

@Composable
fun CarDescription(carData: CarModel) {
    Column(modifier = Modifier.background(color = Color.Gray).fillMaxWidth()) {
        Text(text = carData.description)
        CarDescriptionLine(label = "Color", content = carData.color)
    }
}

@Composable
fun CarDescriptionLine(label: String, content: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = label)
        Text(text = content)
    }
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text(text = "${count.value}")
    }
}