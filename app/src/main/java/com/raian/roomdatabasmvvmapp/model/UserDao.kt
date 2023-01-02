package com.raian.roomdatabasmvvmapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface  UserDao{
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun addUser(user:User)

        @Query("SELECT * FROM user_table ORDER BY id ")
        fun readAllUser(): LiveData<List<User>>

        @Update
        suspend fun updateUser(user:User)

        @Delete
        suspend fun deleteUser(user:User)

        @Query("DELETE FROM user_table")
        suspend fun deleteAll()

}