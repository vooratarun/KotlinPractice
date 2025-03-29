package com.example.kotlinpractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinpractice.basicviews.BasicViewsActivity
import com.example.kotlinpractice.bottomnav.BottomNavActivity
import com.example.kotlinpractice.drawerprac.NaigationDrawerActivity
import com.example.kotlinpractice.scrolling.ScrollingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.basicviews);
        button.setOnClickListener( View.OnClickListener {
            val intentnew = Intent(this, BasicViewsActivity::class.java);
            startActivity(intentnew);
        })

        val navdrawer = findViewById<Button>(R.id.navdrawer);
        navdrawer.setOnClickListener( View.OnClickListener {
            val intentnew = Intent(this, NaigationDrawerActivity::class.java);
            startActivity(intentnew);
        })

        val bottomnav = findViewById<Button>(R.id.bottomnav);
        bottomnav.setOnClickListener( View.OnClickListener {
            val intentnew = Intent(this, BottomNavActivity::class.java);
            startActivity(intentnew);
        })

        val scrolling = findViewById<Button>(R.id.scrolling);
        scrolling.setOnClickListener(View.OnClickListener {
            val intentnew = Intent(this, ScrollingActivity::class.java);
            startActivity(intentnew);
        })

    }
}