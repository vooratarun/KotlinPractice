package com.example.kotlinpractice.mvvmcoroutine

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users") // Endpoint
    suspend fun getUsers(): List<User>

//    @GET("users")
//    suspend fun getUsers(
//        @Query("page") page: Int,
//        @Query("limit") limit: Int = 10 // Fetch 10 users per page
//    ): List<User>
}
