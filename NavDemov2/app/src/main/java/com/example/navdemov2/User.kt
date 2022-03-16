package com.example.navdemov2

import android.icu.util.LocaleData
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class User (
    val name:String,
    val id:String,
    val created: LocalDateTime


  ):Parcelable
{

}

