package com.example.kotlinpractice.mvvmcoroutine

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.kotlinpractice.R

class MvvmCoroutineActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels();
    private lateinit var userAdapter: UserAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_coroutine)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewUsers)
        val retryButton = findViewById<Button>(R.id.retryButton) // Reference retry button
        swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)




        userAdapter = UserAdapter(emptyList()) // Initially empty

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        // Observe ViewModel LiveData
        userViewModel.users.observe(this) { users ->
            userAdapter.updateUsers(users)
            swipeRefreshLayout.isRefreshing = false // Stop refreshing animation
        }

        // Observe error messages
        userViewModel.errorMessage.observe(this) { errorMessage ->
            if (errorMessage != null) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                retryButton.visibility = View.VISIBLE // Show retry button
            } else {
                retryButton.visibility = View.GONE // Hide retry button if no errors
            }
            swipeRefreshLayout.isRefreshing = false // Stop refreshing animation

        }

        // Swipe to Refresh Listener
        swipeRefreshLayout.setOnRefreshListener {
            userViewModel.loadUsers() // Fetch fresh data on swipe
        }


        // Retry button click event
        retryButton.setOnClickListener {
            userViewModel.loadUsers()
        }

        swipeRefreshLayout.isRefreshing = true // Show refresh animation initially
        // Fetch data from API
        userViewModel.loadUsers()

    }
}