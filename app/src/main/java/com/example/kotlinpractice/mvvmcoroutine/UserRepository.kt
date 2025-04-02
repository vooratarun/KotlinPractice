package com.example.kotlinpractice.mvvmcoroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException


sealed class ApiResult<out T>{
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val message: String) : ApiResult<Nothing>()
}

class UserRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun fetchUsers(): ApiResult<List<User>> {
        return withContext(Dispatchers.IO) {
            try {
                val users = apiService.getUsers()
                ApiResult.Success(users)
            } catch (e : IOException){
                ApiResult.Error("Network error! Check your internet connection.")
            } catch (e: HttpException) { // HTTP errors (404, 500, etc.)
                ApiResult.Error("Server error! Code: ${e.code()}")
            } catch (e: Exception) { // Any other unknown error
                ApiResult.Error("Unexpected error: ${e.localizedMessage}")
            }
        }
    }
}
