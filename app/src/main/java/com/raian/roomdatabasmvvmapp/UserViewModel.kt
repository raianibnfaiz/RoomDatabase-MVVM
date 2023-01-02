package com.raian.roomdatabasmvvmapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.raian.roomdatabasmvvmapp.model.User
import com.raian.roomdatabasmvvmapp.model.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
     val readAllData: LiveData<List<User>>
     val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application)?.getDao()
        repository = userDao?.let {
            UserRepository(it) }!!
        readAllData = repository.readAllData
    }

    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
    fun updateUser(user:User){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
    fun deleteUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}