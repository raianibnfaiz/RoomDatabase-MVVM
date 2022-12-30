package com.raian.roomdatabasmvvmapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface  UserDao{
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun addUser(user:User)

        @Query("SELECT * FROM user_table ORDER BY id ")
        fun readAllUser(): LiveData<List<User>>
}