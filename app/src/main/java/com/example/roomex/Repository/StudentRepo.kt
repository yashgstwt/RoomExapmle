package com.example.roomex.Repository

import com.example.roomex.dataLayer.StudentDAO
import com.example.roomex.dataLayer.StudentInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StudentRepo @Inject constructor (val  dao : StudentDAO):RepoInterface {
    override suspend fun getStudentData(): Flow<List<StudentInfo>> {
        return withContext(Dispatchers.IO){ dao.getStudentsData() }
    }

    override suspend fun insert(student: StudentInfo) {
        withContext(Dispatchers.IO){ dao.insert(student) }
    }

    override suspend fun delete(student: StudentInfo) {
        withContext(Dispatchers.IO){ dao.delete(student) }
    }
}