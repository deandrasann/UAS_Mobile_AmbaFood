package com.example.ambafood.network

import com.example.ambafood.model.Cart
import com.example.ambafood.model.Foods
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    @GET("IpPs0/foods")
    fun getAllFoods(): Call<List<Foods>>

    @POST("IpPs0/foods")
    fun addFood(@Body food: Foods): Call<Foods>

//
//    @PUT("updateSold")
//    fun updateSold(@Body cartItems: List<Cart>): Call<Void>
}