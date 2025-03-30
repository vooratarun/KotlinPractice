package com.example.kotlinpractice.loginlogout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinpractice.R

class HomeActivity : AppCompatActivity() {

    private lateinit var sharedPrefHelper: SharedPrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sharedPrefHelper = SharedPrefHelper(this)

        val txtWelcome = findViewById<TextView>(R.id.txtWelcome)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val username = sharedPrefHelper.getUser()
        txtWelcome.text = "Welcome, $username!"

        btnLogout.setOnClickListener {
            sharedPrefHelper.logout()

            // Navigate back to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}