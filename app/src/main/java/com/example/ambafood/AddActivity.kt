package com.example.ambafood

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ambafood.databinding.ActivityAddBinding
import com.example.ambafood.model.Foods
import com.example.ambafood.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnSave.setOnClickListener {
                val name = binding.editName.text.toString()
                val description = binding.editDescription.text.toString()
                val price = binding.editPrice.text.toString().toIntOrNull() ?: 0

                val newFood = Foods(
                    id = 0,
                    name = name,
                    description = description,
                    price = price,
                    sold = 0
                )

                addFood(newFood)
            }
            btnCancel.setOnClickListener{
                val intent = Intent(this@AddActivity,MenuActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun addFood(food: Foods) {
        val apiService = ApiClient.getInstance()
        apiService.addFood(food).enqueue(object : Callback<Foods> {
            override fun onResponse(call: Call<Foods>, response: Response<Foods>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@AddActivity, "Food added successfully", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

            override fun onFailure(call: Call<Foods>, t: Throwable) {
                Toast.makeText(this@AddActivity, "Failed to add food", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
