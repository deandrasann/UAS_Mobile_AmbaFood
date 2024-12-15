package com.example.ambafood

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ambafood.database.CartDatabase
import com.example.ambafood.databinding.ActivityCartBinding
import com.example.ambafood.model.Cart
import com.example.ambafood.network.FoodAdapter

class CartActivity : AppCompatActivity() {

    private lateinit var cartAdapter: CartAdapter
    private lateinit var binding: ActivityCartBinding
    private lateinit var cartDatabase: CartDatabase
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager.getInstance(this)

        binding.rvCart.layoutManager = LinearLayoutManager(this)

        cartDatabase = CartDatabase.getDatabase(this)

        loadCartItems()

        binding.btnLogout.setOnClickListener {
            prefManager.clear()
            startActivity(Intent(this@CartActivity, RoleActivity::class.java))
        }
    }

    private fun loadCartItems() {
        cartDatabase.cartDao().getOrder().observe(this, Observer { carts ->
            cartAdapter = CartAdapter(carts)
            binding.rvCart.adapter = cartAdapter 
        })
    }

}
