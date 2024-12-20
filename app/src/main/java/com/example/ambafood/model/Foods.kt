package com.example.ambafood.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class Foods(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("sold")
    val sold: Int,
)
