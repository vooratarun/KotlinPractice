package com.example.kotlinpractice.sharedpref

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinpractice.R

class SharedPrefActivity : AppCompatActivity() {

    private lateinit var sharedPrefHelper: SharedPrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref);

        sharedPrefHelper = SharedPrefHelper(this)

        // Save data
        sharedPrefHelper.saveData("username", "JohnDoe")

        // Retrieve data
        val username = sharedPrefHelper.getData("username")
        Log.d("SharedPref", "Username: $username")
    }
}