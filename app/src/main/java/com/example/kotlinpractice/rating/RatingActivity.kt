package com.example.kotlinpractice.rating

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinpractice.R

class RatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rating)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ratingBar = findViewById<RatingBar>(R.id.rating_bar)
        val submitButton = findViewById<Button>(R.id.btn_submit)
        val resultTextView = findViewById<TextView>(R.id.tv_result)

        submitButton.setOnClickListener {
            val rating = ratingBar.rating
            resultTextView.text = "Rating: $rating"
            Toast.makeText(this, "Thanks for rating", Toast.LENGTH_SHORT).show()

        }

    }
}