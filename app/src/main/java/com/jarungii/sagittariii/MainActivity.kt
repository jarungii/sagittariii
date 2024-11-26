package com.jarungii.sagittariii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScreen()
        }
    }
}

@Composable
fun GameScreen() {
    val stars = remember { mutableStateListOf<Star>() }
    var score by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            val newStar = Star(
                x = Random.nextFloat() * 800f,
                y = Random.nextFloat() * 600f,
                color = Color.Red,
                bonus = Random.nextInt(1, 100)
            )
            stars.add(newStar)
            kotlinx.coroutines.delay(1000)
        }
    }

    Canvas(modifier = Modifier.fillMaxSize().pointerInput(Unit) {
        detectTapGestures(
            onTap = { offset ->
                stars.removeIf { star ->
                    val distance = Math.sqrt(
                        Math.pow((star.x - offset.x).toDouble(), 2.0) +
                                Math.pow((star.y - offset.y).toDouble(), 2.0)
                    )
                    if (distance < 30) {
                        score += star.bonus
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }) {
        stars.forEach { star ->
            drawCircle(star.color, radius = 20f, center = Offset(star.x, star.y))
        }
    }

    androidx.compose.material3.Text(
        text = "Score: $score",
        color = Color.Black,
        modifier = Modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GameScreen()
}
