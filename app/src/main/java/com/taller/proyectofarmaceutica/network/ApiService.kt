package com.taller.proyectofarmaceutica.network

import com.taller.proyectofarmaceutica.models.Producto
import com.taller.proyectofarmaceutica.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    fun login(@Body user: User): Call<String>

    @GET("/api/producto/getAll")
    fun getAllProductos(): Call<List<Producto>>
}