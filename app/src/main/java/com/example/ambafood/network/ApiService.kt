package com.example.ambafood.network

import com.example.ambafood.model.Foods
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("IpPs0/foods")
    fun getAllFoods(): Call<List<Foods>>
}