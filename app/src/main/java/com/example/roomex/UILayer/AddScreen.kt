package com.example.roomex.UILayer


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roomex.ViewModal.StudentViewModal
import com.example.roomex.dataLayer.StudentInfo

@Composable
fun AddScreen(viewModel: StudentViewModal){

    val name by viewModel.setName.collectAsStateWithLifecycle()
    val onEnteredName : (value : String) -> Unit = remember {
        return@remember viewModel::SetName
    }

    val age by viewModel.setAge.collectAsStateWithLifecycle()
    val onEnteredAge : ( value : Int) -> Unit = remember {
        return@remember viewModel::SetAge
    }

    val result  by viewModel.setResult.collectAsStateWithLifecycle()
    val onEnteredResult : ( value : Boolean )-> Unit = remember {
        return@remember viewModel::setResult
    }

    val onSubmit : (value :StudentInfo)-> Unit = remember {
        return@remember viewModel::insertStudent
    }




    Column(modifier = Modifier.fillMaxSize(.5f) ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

    OutlinedTextField(
        value = name ,
        onValueChange = { onEnteredName(it) },
        placeholder = {
            Text(text = "Enter the Name of Student")
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(),
        maxLines = 1
    )

    Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = age.toString() ,
            onValueChange = { onEnteredAge(it.toInt()) },
            placeholder = {
                Text(text = "Enter the Age of Student")
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(),
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedIconButton(onClick = { onSubmit( StudentInfo ( name = name , age = age , result = result)) })
        {
Text(text = "Submit")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Checkbox(checked = result , onCheckedChange = {
           onEnteredResult(it)
        })

    }

}