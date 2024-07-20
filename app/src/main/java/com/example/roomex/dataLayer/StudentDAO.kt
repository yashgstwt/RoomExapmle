package com.example.roomex.dataLayer

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDAO {

    @Upsert
    suspend fun insert(student:StudentInfo)

    @Delete
    suspend fun delete(student:StudentInfo)

    @Query("Select * from StudentInfo ")
    fun getStudentsData(): Flow<List<StudentInfo>>

}