package com.taller.proyectofarmaceutica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taller.proyectofarmaceutica.models.CartItem

class CartActivity : AppCompatActivity() {

    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        cartRecyclerView = findViewById(R.id.cartRecyclerView)
        setupCart()
    }

    private fun setupCart() {
        val cartItems = CartManager.getCartItems()
        cartAdapter = CartAdapter(cartItems)
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        cartRecyclerView.adapter = cartAdapter
    }
}
