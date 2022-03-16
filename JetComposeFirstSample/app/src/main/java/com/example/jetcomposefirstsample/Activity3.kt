package com.example.jetcomposefirstsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetcomposefirstsample.ui.theme.JetComposeFirstSampleTheme

class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeFirstSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                    val context = LocalContext.current
                    Column() {
                        Button(onClick = { context.startActivity((Intent(context,Activity4::class.java))) }) {

                            Text(text = "Go to Activity4")
                        }



                    }
                    LazyList()
                }
            }
        }
    }
}

@Composable
fun ImageListItem(index:Int)
{
    Row(verticalAlignment = Alignment.CenterVertically){

        Image(painter = rememberImagePainter(data="https://wallpaperaccess.com/full/1650669.jpg"),
            contentDescription = "Robot",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("item #$index", style= MaterialTheme.typography.subtitle1)
    }
}




@Composable
fun  LazyList(){

    var scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {

            repeat(100)
            {
                ImageListItem(index=it )
            }
    }




}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetComposeFirstSampleTheme {
        Greeting2("Android")
    }
}

@Preview
@Composable
fun PreviewSimpleList()
{

    LazyList()
}