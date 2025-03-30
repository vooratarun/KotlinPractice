package com.example.kotlinpractice.retromvvm

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {
    fun getPosts(callback: (List<Post>?) -> Unit) {
        RetrofitClient.instance.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                callback(null)
            }
        })
    }
}
