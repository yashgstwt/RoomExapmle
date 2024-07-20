package com.example.roomex.dataLayer

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class StudentInfo (

    @PrimaryKey(autoGenerate = true)
    val rollNo:Int = 0,
    val name : String = "",
    val age :Int = 0,
    val result :Boolean = true

)
