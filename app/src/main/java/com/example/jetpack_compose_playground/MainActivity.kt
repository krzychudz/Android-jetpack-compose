package com.example.jetpack_compose_playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.ui.tooling.preview.Preview
import com.example.jetpack_compose_playground.ui.Jetpack_compose_playgroundTheme
import com.example.jetpack_compose_playground.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContent {
            MyApp {
                MainScreen(viewModel)
            }
        }
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
fun MainScreen(viewModel: MainActivityViewModel?) {

    //val carData by viewModel?.carData.observerAs

    ScrollableColumn() {
        Stack() {
            Image(
                asset = imageResource(id = R.drawable.audi),
                modifier = Modifier.preferredHeightIn(160.dp, 260.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = "Test")
        }
        Divider(color = Color.Black, thickness = 14.dp)
        Counter()
    }
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text(text = "${count.value}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainScreen(null)
    }
}