package com.example.roomex.Repository

import com.example.roomex.dataLayer.StudentDAO
import com.example.roomex.dataLayer.StudentInfo
import kotlinx.coroutines.flow.Flow

interface RepoInterface {
     suspend fun getStudentData () :Flow<List<StudentInfo>>

     suspend fun  insert (student : StudentInfo)

     suspend fun delete(student : StudentInfo)
}