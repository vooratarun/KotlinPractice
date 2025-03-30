package com.example.kotlinpractice.loginlogout

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("UserSession", Context.MODE_PRIVATE)

    fun saveLoginStatus(isLoggedIn: Boolean) {
        sharedPref.edit().putBoolean("isLoggedIn", isLoggedIn).apply()
    }

    fun isLoggedIn(): Boolean {
        return sharedPref.getBoolean("isLoggedIn", false)
    }

    fun saveUser(username: String) {
        sharedPref.edit().putString("username", username).apply()
    }

    fun getUser(): String? {
        return sharedPref.getString("username", null)
    }

    fun logout() {
        sharedPref.edit().clear().apply()
    }
}
