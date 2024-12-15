package com.example.ambafood.network

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ambafood.databinding.ItemFoodBinding
import com.example.ambafood.model.Cart
import com.example.ambafood.model.Foods

class FoodAdapter(
    private val foodList: List<Foods>,
    private val onCartClick: (Cart) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.binding.foodName.text = food.name
        holder.binding.foodDescription.text = food.description
        holder.binding.foodPrice.text = food.price.toString()

        holder.binding.btnAddToCart.setOnClickListener{
            val cart = Cart(
                id = food.id,
                name = food.name,
                price = food.price,
                description = food.description,
                sold = food.sold
            )
            onCartClick(cart)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}