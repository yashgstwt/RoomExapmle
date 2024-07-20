package com.example.roomex.dataLayer

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentInfo::class] , version = 1)
abstract class StudentDataBase :RoomDatabase() {
abstract val  dao : StudentDAO

}