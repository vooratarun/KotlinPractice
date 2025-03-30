package com.example.kotlinpractice.retromvvm

import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceMVVM {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}
