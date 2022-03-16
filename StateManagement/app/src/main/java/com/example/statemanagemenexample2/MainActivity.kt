package com.example.statemanagemenexample2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.tooling.preview.Preview
import com.example.statemanagemenexample2.ui.theme.StateManagemenExample2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateManagemenExample2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                rememberState()
                }
            }
        }
    }
}

@Composable
fun rememberState()
{
    var context = LocalContext.current
    var clickCount by remember { mutableStateOf(0) }
    Column(){

        Button(onClick={

            clickCount++
        })
        {
        Text(text="" + clickCount + "Times clicked")
        }

        Button(onClick={

            context.startActivity(Intent(context, Details::class.java))
        })
        {
            Text("Go next activity")
        }

    }
}