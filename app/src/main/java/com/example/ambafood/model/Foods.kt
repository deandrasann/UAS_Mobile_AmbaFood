package com.example.ambafood.model

import com.google.gson.annotations.SerializedName

data class Foods(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("sold")
    val sold: Int,
)
