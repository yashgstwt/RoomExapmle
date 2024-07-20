package com.example.roomex.Module

import android.app.Application
import androidx.room.Room
import com.example.roomex.Repository.StudentRepo
import com.example.roomex.dataLayer.StudentDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object StudentModule {

    @Provides
    @Singleton
    fun provideDataBase (app : Application) :StudentDataBase {
        return Room.databaseBuilder(app , StudentDataBase::class.java , "StudentDataBase").build()

    }
    @Provides
    @Singleton
    fun provideRepository(dataBase: StudentDataBase) : StudentRepo{
        return StudentRepo(dataBase.dao)

    }
}