package com.example.kotlinpractice.retro

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpractice.R
import com.example.kotlinpractice.databinding.ActivityRetrofitBinding
import com.example.kotlinpractice.databinding.ActivityScrollingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRetrofitBinding

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView;
        recyclerView.layoutManager = LinearLayoutManager(this);

        fetchPosts();
    }

    private  fun fetchPosts() {
        RetrofitClient.instance.getPosts().enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if(response.isSuccessful) {
                    val posts = response.body() ?: emptyList();
                    recyclerView.adapter = PostAdapter(posts);
                } else {
                    Toast.makeText(
                        this@RetrofitActivity,
                        "failed to fetch posts ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("API_ERROR", "Error: ${t.message}")
                Toast.makeText(this@RetrofitActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}