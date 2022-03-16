package com.example.navdemov2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navdemov2.ui.theme.NavDemov2Theme
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavDemov2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController =navController , startDestination = Screen.login_screen.route ){
                        composable(Screen.login_screen.route)
                        {
                            LoginScreen(navController = navController)
                        }


                        composable(Screen.profile_screen.route+"/{name}/{userId}/{timestamp}",
                        arguments = listOf(
                            navArgument("name"){
                                type = NavType.StringType
                            },
                            navArgument("userId"){
                                type = NavType.StringType
                            },
                            navArgument("timestamp"){
                                type = NavType.LongType
                            }


                            )
                        )
                        {
                            var name =   it.arguments?.getString("name")
                            var userId =   it.arguments?.getString("userId")
                            var timestamp =   it.arguments?.getLong("timestamp")
                            if(name!=null && userId!=null && timestamp != null)
                            ProfileScreen(navController = navController, name, userId,  timestamp )
                        }

                        composable(Screen.post_screen.route + "/{bool}",
                            arguments = listOf(
                                navArgument("bool"){
                                    type=NavType.BoolType
                                }
                            )

                            )
                        {
                            var bool = it.arguments?.getBoolean("bool")
                            if (bool!=null)
                            PostScreen(navController = navController, bool)
                        }



                    }



                }
            }
        }
    }
}

@Composable
fun LoginScreen(navController:NavController){

    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text= "Login Screen")
        var tru:Boolean = true
            Button(onClick = {
                navController.navigate(Screen.profile_screen.route+"/Peter/1234/5678")

            }){
                Text(text="go to profile screen")
            }

        }

}

@Composable
fun ProfileScreen(navController: NavController, name:String, userId:String, created:Long){

    val user = rememberSaveable {
        User(name=name, id=userId, created = LocalDateTime.ofInstant(Instant.ofEpochMilli(created), ZoneId.systemDefault()))
    }
    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text= "profile Screen:$user", textAlign = TextAlign.Center)
        Button(onClick = {
            navController.navigate(Screen.post_screen.route+"/true")

        }){
            Text(text="go to post screen")
        }

    }
}

@Composable
 fun PostScreen(navController: NavController, showPost:Boolean = false){

    Box(modifier=Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
        )
    {
        Text(text= "Post Screen $showPost")


    }
}

@Composable
fun textFieldExample()
    {
        var status by rememberSaveable { mutableStateOf("")}
        var username by rememberSaveable{ mutableStateOf("")}
        var password by rememberSaveable{ mutableStateOf("")}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)

        ) {

            TextField(value = username, onValueChange = {username=it},
                label ={ Text(text=username)})

            Text(text = "Username")

            TextField(value = password, onValueChange = {password=it},
                label ={ Text(text=password)})

            Text(text = "Password")

            var username by rememberSaveable{ mutableStateOf("")}
            var password by rememberSaveable{ mutableStateOf("")}
            Button(onClick = { status=Login(username,password)
                                Log.d(TAG, "username is $username pass is $password")
                }) {
                Text(text = "Log in")
            }
            Text(text=status)

        }




    }
    fun Login(un:String,pw:String):String{
        var status:String =""
        var user="username"
        var pass="password"
        Log.d(TAG, "un is $un pw is $pw")
         if (un==user && pw==pass){
            status =  " logged in"
        }else{
            status = "Not logged in"
        }
        Log.d(TAG, "stats is $status")
        return status
    }
