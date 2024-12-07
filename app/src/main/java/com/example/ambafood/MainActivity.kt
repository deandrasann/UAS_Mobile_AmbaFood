package com.example.ambafood

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ambafood.databinding.ActivityMainBinding
import com.example.ambafood.model.Foods
import com.example.ambafood.network.ApiClient
import com.example.ambafood.network.FoodAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.rvFoods.layoutManager = LinearLayoutManager(this)

        fetchFoodList()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun fetchFoodList(){
        val apiService = ApiClient.getInstance()
        apiService.getAllFoods().enqueue(object : Callback<List<Foods>> {
            override fun onResponse(call: Call<List<Foods>>, response: Response<List<Foods>>) {
                if (response.isSuccessful) {
                    val foodList = response.body()!!
                    foodAdapter = FoodAdapter(foodList)
                    binding.rvFoods.adapter = foodAdapter
                }
            }

            override fun onFailure(call: Call<List<Foods>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}