package com.example.kotlinpractice.mvvmcompose

class UserRepository {
//    fun getUsers(): List<User> {
//        return listOf(
//            User(1, "Alice", 25),
//            User(2, "Bob", 30),
//            User(3, "Charlie", 28)
//        )
//    }


    private val apiService = RetrofitInstance.api

    suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}
