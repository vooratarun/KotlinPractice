package com.example.kotlinpractice.loginlogout

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinpractice.R

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPrefHelper: SharedPrefHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPrefHelper = SharedPrefHelper(this)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etUsername = findViewById<EditText>(R.id.etUsername)

        btnLogin.setOnClickListener(View.OnClickListener {
            val username = etUsername.text.toString().trim()
            if (username.isNotEmpty()) {
                sharedPrefHelper.saveUser(username)
                sharedPrefHelper.saveLoginStatus(true)

                // Navigate to HomeActivity after login
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show()
            }
        })


    }
}