package com.example.roomex.ViewModal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomex.Repository.StudentRepo
import com.example.roomex.dataLayer.StudentInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModal @Inject constructor( val  repo: StudentRepo):ViewModel() {

    private val _studentList  = MutableStateFlow(emptyList<StudentInfo>())
    var studentList =  _studentList.asStateFlow()


    fun getStudentList(){
        viewModelScope.launch(IO) {
            repo.getStudentData().collectLatest {
                _studentList.tryEmit(it)
            }
        }
    }

    fun insertStudent(student: StudentInfo){
        viewModelScope.launch(IO) {
            repo.insert(student)
        }
    }

    fun deleteStudent(student :StudentInfo){
        viewModelScope.launch {
            repo.delete(student)
        }
    }

    private val _setName = MutableStateFlow("")
    var setName=_setName.asStateFlow()

    fun SetName(name :String ){
        _setName.tryEmit(name)
    }


    private val _setAge = MutableStateFlow(0)
    var setAge = _setAge.asStateFlow()

    fun SetAge (age :Int){
        _setAge.update { age } //can also use tryEmit(it)

    }

    private val _setResult = MutableStateFlow(true)
    var setResult = _setResult.asStateFlow()

    fun setResult(result :Boolean){
        _setResult.tryEmit(result)

    }


}