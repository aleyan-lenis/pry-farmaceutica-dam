package com.taller.proyectofarmaceutica.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Factura(
    @SerializedName("idFactura") val idFactura: Long,
    @SerializedName("productos") val productos: List<Producto>,
    @SerializedName("cliente_id") val cliente: Cliente,
    @SerializedName("fecha") val fecha: Date,
    @SerializedName("numero_factura") val numeroFactura: Int
)
