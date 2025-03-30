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
import com.example.kotlinpractice.rating.RatingActivity
import com.example.kotlinpractice.retro.RetrofitActivity
import com.example.kotlinpractice.retromvvm.RetrofitMVVMActivity
import com.example.kotlinpractice.retrouser.RetrouserActivity
import com.example.kotlinpractice.scrolling.ScrollingActivity
import com.example.kotlinpractice.tabbedviews.TabbedViewsActivity

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

        val tabbedviews = findViewById<Button>(R.id.tabbedviews);
        tabbedviews.setOnClickListener(View.OnClickListener {
            val intentnew = Intent(this, TabbedViewsActivity::class.java);
            startActivity(intentnew);
        })

        val rating = findViewById<Button>(R.id.rating);
        rating.setOnClickListener(View.OnClickListener {
            val intentnew = Intent(this, RatingActivity::class.java);
            startActivity(intentnew);
        })

        val retrofit = findViewById<Button>(R.id.retrofit);
        retrofit.setOnClickListener(View.OnClickListener {
            val intentnew = Intent(this, RetrofitActivity::class.java);
            startActivity(intentnew);
        })

        val retroUser = findViewById<Button>(R.id.retrouser);
        retroUser.setOnClickListener(View.OnClickListener {
            val intentnew = Intent(this, RetrouserActivity::class.java);
            startActivity(intentnew);
        })

        val retroMvvm = findViewById<Button>(R.id.retromvvm);
        retroMvvm.setOnClickListener(View.OnClickListener {
            val intentnew = Intent(this, RetrofitMVVMActivity::class.java);
            startActivity(intentnew);
        })

    }
}