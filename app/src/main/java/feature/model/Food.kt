package com.catnip.layoutingexample.layoutingexample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food (
    var name: String,
    var price: String,
    val pictUrl: String,
) : Parcelable


