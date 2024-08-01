package com.taller.proyectofarmaceutica

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.taller.proyectofarmaceutica.models.User
import com.taller.proyectofarmaceutica.network.ApiClient
import com.taller.proyectofarmaceutica.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Login : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.editTextText)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.singupButton)

        loginButton.setOnClickListener {
            login()
        }

        registerButton.setOnClickListener {
            register()
        }
    }

    private fun login() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        val user = User(username, password)
        Log.i("Request", user.toString())
        val authService = ApiClient.instance.create(ApiService::class.java)
        val call = authService.login(user)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.i("Response: ",response.toString())
                if (response.isSuccessful) {
                    Toast.makeText(this@Login, "Inicio de sesion exitoso", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@Login, CompraActivity::class.java)
                    startActivity(intent)

                    finish() //con el finish prohibo el retroceso al usuario

                } else {
                    Toast.makeText(this@Login, "Acceso no autorizado", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@Login, "Error general: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.i("Error:" ,"Error en el consumo de login, ${t.message}");
            }
        })
    }

    private fun register() {
        // Implementar registro de usuario ...
    }
}