package com.example.navdemov2

sealed class Screen(val route:String){
    object login_screen:Screen("Login_Screen")
    object profile_screen:Screen("Profile_Screen")
    object post_screen:Screen("Post_Screen")


}
