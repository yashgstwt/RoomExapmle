package com.example.roomex.UILayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.roomex.ViewModal.StudentViewModal

@Composable
fun HomeScreen(viewModal: StudentViewModal){


    LaunchedEffect(key1 = true, block = {
        // we will get the student details when ever the screen is created
// Launched effect is a side effect
        viewModal.getStudentList()
    })

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f), contentAlignment = Alignment.TopCenter
        ) {
            AddScreen(viewModel = viewModal )
        }
        Text(
            text = "Students List",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        BottomContent(viewModal)


    }

}