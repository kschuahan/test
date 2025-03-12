package com.example.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(val noteRoomDatabase: NoteRoomDatabase) : ViewModel() {

    private val _noteList = MutableStateFlow<List<NoteModel>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getNotes().collect {
                _noteList.value = it
            }
        }

    }

     fun insertNote(note: NoteModel) {
         viewModelScope.launch(Dispatchers.IO) {
        noteRoomDatabase.noteDao().insert(note)
         }
    }


    private suspend fun getNotes() = noteRoomDatabase.noteDao().getNotes()
}