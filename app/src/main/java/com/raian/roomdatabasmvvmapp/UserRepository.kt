package com.raian.roomdatabasmvvmapp

import androidx.lifecycle.LiveData
import com.raian.roomdatabasmvvmapp.model.User
import com.raian.roomdatabasmvvmapp.model.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllUser()

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }

}