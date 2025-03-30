package com.example.kotlinpractice.retromvvm

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpractice.R

class RetrofitMVVMActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_mvvmactivity);

        val recyclerView   = findViewById<RecyclerView>(R.id.recyclerView);
        recyclerView.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter(emptyList())
        recyclerView.adapter = postAdapter;

        val btnFetch = findViewById<Button>(R.id.btnFetch)
        btnFetch.setOnClickListener(View.OnClickListener {
            postViewModel.fetchPosts();
        })

         postViewModel.posts.observe(this) { posts ->
             println("postes fetched ${posts.size}")
             postAdapter.updatePosts(posts);
         }


    }
}