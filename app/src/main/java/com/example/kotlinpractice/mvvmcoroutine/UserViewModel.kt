package com.example.kotlinpractice.mvvmcoroutine

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository = UserRepository()
    private val _users = MutableLiveData<List<User>>()
    private val _errorMessage = MutableLiveData<String?>()

    val users: LiveData<List<User>> get() = _users
    val errorMessage: LiveData<String?> get() = _errorMessage


    fun loadUsers() {
        viewModelScope.launch {
            when (val result = repository.fetchUsers()) {
                is ApiResult.Success -> {
                    _users.postValue(result.data)
                    _errorMessage.postValue(null) // No errors
                }
                is ApiResult.Error -> {
                    _errorMessage.postValue(result.message) // Pass error to UI
                }
            }
        }
    }
}
