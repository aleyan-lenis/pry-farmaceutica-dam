package com.taller.proyectofarmaceutica.models

data class CartItem(val id: Long,
                    val nombreProducto: String,
                    val precioProducto: Float,
                    var cantidad: Int)
