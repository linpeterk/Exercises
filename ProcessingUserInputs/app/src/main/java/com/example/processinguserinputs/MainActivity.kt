package com.example.processinguserinputs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.processinguserinputs.ui.theme.ProcessingUserInputsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProcessingUserInputsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
        textFieldExample()
                }
            }
        }
    }
}

@Composable
fun textFieldExample()
{
//    var username by rememberSaveable {mutableStateOf("")}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxWidth()
       // .padding(20.dp)
        .border(1.dp, Color.Red, RectangleShape)
        .padding(20.dp)
    ){

        var username by rememberSaveable {mutableStateOf("")}
        TextField(value=username,
            onValueChange = {username = it},
            label = {Text("User Name:")}
            ,
        )
        Spacer(modifier = Modifier.padding(10.dp))

        var password by rememberSaveable {mutableStateOf("")}

        TextField(value=password,
            onValueChange = {password = it},
            label = {Text("Password:")}
            ,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        var test:String
     //   var result by rememberSaveable {mutableStateOf("Click Me")}

        Button(onClick={},
            modifier = Modifier.fillMaxWidth()
                .height(40.dp)
                ){
            test = validation(username, password)
                Text(test)
        }
    }
}

fun validation(userName:String, password:String):String{
    val loginName = "Peter"
    val loginPass = "123"

      if (userName.equals(loginName) && password.equals(loginPass))
        return "Success"
    else return "Not Success"
}