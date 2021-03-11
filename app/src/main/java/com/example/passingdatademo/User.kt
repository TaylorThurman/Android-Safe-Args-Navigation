package com.example.passingdatademo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(val id: Int, val name: String, val age: Int): Parcelable {
    val descripton: String
        get() = "$name is $age years old"
}

