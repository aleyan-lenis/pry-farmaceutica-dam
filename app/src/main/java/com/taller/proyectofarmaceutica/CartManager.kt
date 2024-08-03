package com.taller.proyectofarmaceutica

import com.taller.proyectofarmaceutica.models.CartItem

object CartManager {
    private val cartItems = mutableListOf<CartItem>()

    fun addToCart(item: CartItem) {
        val existingItem = cartItems.find { it.id == item.id }
        if (existingItem != null) {
            existingItem.cantidad += item.cantidad
        } else {
            cartItems.add(item)
        }
    }

    fun getCartItems(): List<CartItem> = cartItems

    fun clearCart() {
        cartItems.clear()
    }
}