package com.example.kotlinpractice.retrouser

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinpractice.R
import com.example.kotlinpractice.retrouser.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrouserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrouser)

        val buttonGetUsers = findViewById<Button>(R.id.getUsers);
        val createUser =  findViewById<Button>(R.id.createUser);

        buttonGetUsers.setOnClickListener{
            RetrofitClient.instance.getUsers().enqueue(object  : Callback<List<User>>{
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if(response.isSuccessful) {
                        response.body()?.forEach({
                            Log.d("User", "ID: ${it.id}, Name: ${it.name}, Email: ${it.email}")
                        })
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.e("API_ERROR", "Error: ${t.message}")
                }
            })
        }

        createUser.setOnClickListener({
            RetrofitClient.instance.createUser("ads","Adf@gmail.comm")
                .enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        if(response.isSuccessful) {
                            val user = response.body();
                            Toast.makeText(this@RetrouserActivity, "User created ${user?.name}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {

                        Log.e("API_ERROR", "Error: ${t.message}")

                    }

                })
        })

    }
}