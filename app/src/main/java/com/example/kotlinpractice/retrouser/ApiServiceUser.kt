package com.example.kotlinpractice.retrouser

import retrofit2.Call
import retrofit2.http.*

interface ApiServiceUser {

    // GET request to fetch a list of users
    @GET("users")
    fun getUsers(): Call<List<User>>

    // POST request to create a new user
    @POST("users")
    @FormUrlEncoded
    fun createUser(
        @Field("name") name: String,
        @Field("email") email: String
    ): Call<User>
}
