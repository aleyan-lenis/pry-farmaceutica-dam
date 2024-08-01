package com.taller.proyectofarmaceutica.models

import com.google.gson.annotations.SerializedName

data class Producto(
    @SerializedName("IdProducto") val idProducto: Long,
    @SerializedName("nombreProducto") val nombreProducto: String,
    @SerializedName("descripcionProducto") val descripcionProducto: String,
    @SerializedName("precioProducto") val precioProducto: Float,
    @SerializedName("cantidadStockProducto") val cantidadStockProducto: Int,
    @SerializedName("categoria") val categoria: Categoria
)
