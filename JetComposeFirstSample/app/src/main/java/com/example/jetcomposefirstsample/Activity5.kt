package com.example.jetcomposefirstsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcomposefirstsample.ui.theme.JetComposeFirstSampleTheme
import com.example.jetcomposefirstsample.ui.theme.testOrange

class Activity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                    Column() {
                        val context = LocalContext.current

                        PhotoGrapherCard()
                        Navigation()


                    }
                }
            }
        }



@Composable
fun Navigation()
{

    Column(){
        TopAppBar(title= { Text(text="State Management")}, Modifier.height(50.dp))
        Spacer(modifier = Modifier.height(5.dp))
        var context= LocalContext.current
        Button(onClick = { context.startActivity(Intent(context, MainActivity::class.java )) }) {

            Text(text="Go to Main Screen")

        }
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = { context.startActivity(Intent(context, MainActivity::class.java )) }) {

            Text(text="Go to screen")

        }
    }

}

@Composable
fun PhotoGrapherCard(modifier:Modifier = Modifier){
    Row( modifier.padding(16.dp)
        .padding(8.dp)
        .clickable(onClick= {  })
        .background(MaterialTheme.colors.secondary) //secondary is teal
        .clip(RoundedCornerShape(4.dp))
    ){

        Surface(
            modifier = Modifier.size(50.dp),
            shape= CircleShape,
            color= MaterialTheme.colors.onSurface.copy(alpha=0.2f)


        ){
            Image(
                painter = painterResource(id = R.drawable.toilet_paper),
                contentDescription = "Circle picture", modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, testOrange, RectangleShape)
            )
        }



        Column() {



            Text(text = "Alfred", fontWeight = FontWeight.Bold)
            Text(text = "3 minutes ago", style = MaterialTheme.typography.body2)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreViewPhoto() {
    PhotoGrapherCard()
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
   Navigation()
}