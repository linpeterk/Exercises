package com.example.jetcomposefirstsample


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcomposefirstsample.ui.theme.JetComposeFirstSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

          //  Text(text="Hello Android!")


            MessageCard(Messages("Android","Jetpack Compose"))
            //PreviewMessageCard()
        }
    }
}

data class Messages(val author:String, val body:String)


@Composable
fun MessageCard(msg:Messages)
{
    val context = LocalContext.current

    Row (modifier = Modifier.padding(8.dp)
                            .fillMaxSize()
        , verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Toilet", modifier= Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)

                )


        Spacer(modifier = Modifier.width(16.dp))
        
        
        Column {

            Text(text = msg.author, color=MaterialTheme.colors.secondaryVariant,
                style= MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)

            Button(onClick = { Log.d("Button Clicked", "Clicking button") }) {
                Text(text = "BIG Button")
            }

            Button(onClick = { context.startActivity((Intent(context,Activity2::class.java))) }) {
                Text(text = "Go to Activity2")
            }
            Button(onClick = { context.startActivity((Intent(context,Activity5::class.java))) }) {
                Text(text = "Go to Activity5")
            }
        }

    }

  //  Text(text= "Peter")
  //  Text(text= "Body")
}

@Preview
@Composable
fun PreviewMessageCard()
{
    JetComposeFirstSampleTheme {
        MessageCard(Messages("Android", "Jetpack Compose"))
    }
}

@Composable
fun setupStateUsingState(){



}