package com.raian.roomdatabasmvvmapp

import androidx.lifecycle.LiveData
import com.raian.roomdatabasmvvmapp.model.User
import com.raian.roomdatabasmvvmapp.model.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllUser()

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }
    suspend fun updateUser(user:User){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAll(){
        userDao.deleteAll()
    }

}