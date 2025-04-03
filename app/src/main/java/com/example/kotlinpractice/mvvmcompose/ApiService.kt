package com.example.kotlinpractice.mvvmcompose

import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
