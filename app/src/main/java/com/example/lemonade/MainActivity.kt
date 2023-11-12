package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeScreen()
                }
            }
        }
    }
}

fun nextScreen(number: Int): Int {
    return when (number) {
        0 -> 1
        1 -> 2
        2 -> 3
        else -> 0
    }
}

fun screenImage(number: Int): Int {
    return when (number) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
}

fun screenText(number: Int): Int {
    return when (number) {
        0 -> R.string.lemonade_step1
        1 -> R.string.lemonade_step2
        2 -> R.string.lemonade_step3
        else -> R.string.lemonade_step4
    }
}

@Composable
fun LemonadeScreen(modifier: Modifier = Modifier) {
    var screen = 0

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            shape = RoundedCornerShape(8.dp),
            onClick = { screen = nextScreen(screen) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
        ) {
            Image(
                painter = painterResource(id = screenImage(screen)),
                contentDescription = null,
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(stringResource(id = screenText(screen)), fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeScreen()
    }
}