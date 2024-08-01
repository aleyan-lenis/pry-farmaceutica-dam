package com.taller.proyectofarmaceutica.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    //private const val BASE_URL_AUTH = "http://localhost:8080/api/"
    private const val BASE_URL_AUTH = "http://10.0.2.2:8080/api/"
    //private const val BASE_URL_SERVICES =  "localhost:8080/v1/"

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_AUTH)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}