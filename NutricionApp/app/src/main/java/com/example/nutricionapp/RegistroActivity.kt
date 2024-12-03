package com.example.nutricionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val emailEditText = findViewById<EditText>(R.id.email)
        val registerButton = findViewById<Button>(R.id.register_button)

        registerButton.setOnClickListener {
            // Simula un registro
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val email = emailEditText.text.toString()

            // Guardar en base de datos o en memoria (no implementado)
        }
    }
}
