package com.example.test

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun NoteList(modifier: Modifier = Modifier, navController: NavController=rememberNavController()) {

    val viewModel: NoteViewModel = hiltViewModel()
    val noteList = viewModel.noteList.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("addNote")
            }) {
                Text(text = "Add")
            }
        }
    ) {
        LazyColumn(modifier = modifier.padding(it)) {
            itemsIndexed(noteList.value) { _, item ->
                Text(modifier = Modifier.padding(vertical = 20.dp), text = item.note)
            }

        }
    }
}