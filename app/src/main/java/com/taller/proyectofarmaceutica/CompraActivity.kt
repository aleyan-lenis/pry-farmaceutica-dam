package com.taller.proyectofarmaceutica

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taller.proyectofarmaceutica.models.Producto
import com.taller.proyectofarmaceutica.network.ApiClient
import com.taller.proyectofarmaceutica.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompraActivity : AppCompatActivity() {

    private lateinit var productoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compra)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        productoRecyclerView = findViewById(R.id.productosRecyclerView)
        productoRecyclerView.layoutManager = LinearLayoutManager(this)

        obtenerTodosProductos()

    }

    private fun obtenerTodosProductos() {

        val apiService = ApiClient.instance.create(ApiService::class.java)
        apiService.getAllProductos().enqueue(object : Callback<List<Producto>>{

            override fun onResponse(
                call: Call<List<Producto>>,
                response: Response<List<Producto>>
            ) {
                if(response.isSuccessful){
                    val producto = response.body()
                    producto?.let {
                        productoRecyclerView.adapter = ProductosAdapter(it)}
                    }else{
                        Log.e("Error en la compra","Error al obtener los productos: ${response.errorBody()}")
                    }
                }

            override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                Log.e("CompraActivity", "Error en la llamada: ${t.message}")
            }
        })
    }
}