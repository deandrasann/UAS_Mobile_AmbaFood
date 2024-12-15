package com.example.ambafood

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuAdapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ambafood.database.CartDatabase
import com.example.ambafood.databinding.ActivityMainBinding
import com.example.ambafood.databinding.ActivityMenuBinding
import com.example.ambafood.model.Foods
import com.example.ambafood.network.ApiClient
import com.example.ambafood.network.FoodAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdminAdapter
    private lateinit var binding: ActivityMenuBinding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        with(binding){
            btnAddMenu.setOnClickListener{
                val intent = Intent(this@MenuActivity, AddActivity::class.java)
                startActivity(intent)
            }
            btnLogout.setOnClickListener{
                prefManager.clear()
                startActivity(Intent(this@MenuActivity,RoleActivity::class.java))
            }
        }
        fetchMenuList()
    }
    private fun fetchMenuList(){
        val apiService = ApiClient.getInstance()
        apiService.getAllFoods().enqueue(object : Callback<List<Foods>> {
            override fun onResponse(call: Call<List<Foods>>, response: Response<List<Foods>>) {
                if (response.isSuccessful) {
                    val foodList = response.body()!!
                    adapter = AdminAdapter(foodList)
                    binding.rvMenu.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Foods>>, t: Throwable) {
                Toast.makeText(this@MenuActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
