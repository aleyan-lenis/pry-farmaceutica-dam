package com.taller.proyectofarmaceutica.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Cliente(
    @SerializedName("idCliente") val idCliente: Long,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("apellido") val apellido: String,
    @SerializedName("email") val email: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("direccion") val direccion: String,
    @SerializedName("fechaNacimiento") val fechaNacimiento: Date
)