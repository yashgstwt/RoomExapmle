package com.example.roomex.UILayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roomex.ViewModal.StudentViewModal
import com.example.roomex.dataLayer.StudentInfo

@Composable
fun BottomContent(viewModal: StudentViewModal){
    val contents by  viewModal.studentList.collectAsStateWithLifecycle()

    val mod = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .height(80.dp)

    LazyColumn(content = {

        items(contents) {
            val item = ImmutableStudent(it)
            StudentCard(wrapper = item, viewModel = viewModal, mod = mod)
        }
    }, modifier = Modifier.fillMaxSize()
    )

}
@Immutable
data class ImmutableStudent(val studentEntity:  StudentInfo)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentCard(
    wrapper: ImmutableStudent,
    viewModel: StudentViewModal,
    mod: Modifier,
) {


    val onCheckedChange: (value: StudentInfo) -> Unit = remember {
        return@remember viewModel::insertStudent
    }
    Card(
        onClick = {

        }, modifier = mod
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically

        )
        {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {


                Text(
                    text = wrapper.studentEntity.name,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = wrapper.studentEntity.age.toString(),
                    maxLines = 1,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {

                Checkbox(checked = wrapper.studentEntity.result, onCheckedChange = {
                    onCheckedChange(
                        StudentInfo(
                            wrapper.studentEntity.rollNo,
                            wrapper.studentEntity.name,
                            wrapper.studentEntity.age,
                            it
                        )
                    )
                })
            }
        }
    }
}