package com.example.jetcomposefirstsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetcomposefirstsample.ui.theme.JetComposeFirstSampleTheme

private val TAG:String = Activity2::class.java.simpleName
class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if(savedInstanceState != null) Log.d(TAG, "not null")
        super.onCreate(savedInstanceState)

        if(savedInstanceState != null)
        {
            Log.d(TAG, "Oncreate() restoring previous state")
        }
        else{
            Log.d(TAG, "Oncreate() No saved state available")
        }
        Addition()
        setContent {
            val context = LocalContext.current
            Greeting("name")
            /*
            JetComposeFirstSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    Column {
                        Button(onClick = { context.startActivity((Intent(context,Activity3::class.java))) }) {

                            Text(text = "Go to Activity3")
                    }


                    }
                }
            }
            */
        }
    }
}

@Composable
fun Greeting(name: String) {

    Column{
            TopAppBar(
                title={Text(text = "Course management")}
            )
    }


    var tex by remember { mutableStateOf("Button default") }
    Button(onClick = {tex = "Button clicked"}) {

        Text(text = tex)
    }


        Text(text="Hello $name!")


}

fun Addition(){
    try{
        var a:Int =0
        var b:Int =0
        var c = a+b
    }catch(e:Exception)
    {
        Log.d(TAG, "Someothermethods", e)
    }



}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetComposeFirstSampleTheme {
        Greeting("Android")
    }
}