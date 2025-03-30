package com.example.kotlinpractice.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        sharedPref.edit().putString(key, value).apply()
    }

    fun getData(key: String): String? {
        return sharedPref.getString(key, null)
    }

    fun removeData(key: String) {
        sharedPref.edit().remove(key).apply()
    }

    fun clearAll() {
        sharedPref.edit().clear().apply()
    }
}
