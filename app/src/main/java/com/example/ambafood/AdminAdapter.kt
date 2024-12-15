package com.example.ambafood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ambafood.databinding.ItemAdminBinding
import com.example.ambafood.model.Foods
import com.example.ambafood.network.FoodAdapter

class AdminAdapter (private val foodList: List<Foods>) : RecyclerView.Adapter<AdminAdapter.AdminViewHolder>() {

    class AdminViewHolder(val binding: ItemAdminBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminViewHolder {
        val binding = ItemAdminBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdminViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdminViewHolder, position: Int) {
        val food = foodList[position]
        holder.binding.foodName.text = food.name
        holder.binding.foodDescription.text = food.description
        holder.binding.foodPrice.text = food.price.toString()
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}