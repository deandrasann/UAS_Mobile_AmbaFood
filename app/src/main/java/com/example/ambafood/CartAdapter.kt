//package com.example.ambafood
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.ambafood.databinding.ItemCartBinding
//import com.example.ambafood.model.Cart
//
//class CartAdapter (private val cartList: List<Cart>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
//    class CartViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
//        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return CartViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return cartList.size
//    }
//
//    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
//        val cart = cartList[position]
//        holder.binding.itemName.text = cart.name
//        holder.binding.itemPrice.text = cart.price.toString()
//    }
//}

package com.example.ambafood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ambafood.model.Cart

class CartAdapter(private val cartItems: List<Cart>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.itemName.text = cartItem.name
        holder.itemPrice.text = cartItem.price.toString()
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
}
