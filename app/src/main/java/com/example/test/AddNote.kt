package com.example.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun AddNote(modifier: Modifier = Modifier) {

    val viewModel: NoteViewModel = hiltViewModel()
    var note by remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize()) {

        TextField(value = note, onValueChange = {
            note = it
        })

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            viewModel.insertNote(NoteModel(note=note))
        }) {
            Text(text = "Add")
        }

    }
}