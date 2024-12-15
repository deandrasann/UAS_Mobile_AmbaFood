package com.example.ambafood

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ambafood.model.Cart
import com.example.ambafood.model.Foods

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cart : Cart)

    @Delete
    suspend fun delete(cart: Cart)

    @Query("SELECT * FROM cart_table ORDER BY id ASC")
    fun getOrder(): LiveData<List<Cart>>
}