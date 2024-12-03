package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val diagnosticButton = findViewById<Button>(R.id.diagnosticButton)
        val recipesButton = findViewById<Button>(R.id.recipesButton)
        //val profileButton = findViewById<Button>(R.id.profile_button)

        diagnosticButton.setOnClickListener {
            val intent = Intent(this, DiagnosticActivity::class.java)
            startActivity(intent)
        }

        recipesButton.setOnClickListener {
            val intent = Intent(this, RecetasActivity::class.java)
            startActivity(intent)
        }

        //profileButton.setOnClickListener {
        //    val intent = Intent(this, ProfileActivity::class.java)
        //   startActivity(intent)
        //}
    }
}
