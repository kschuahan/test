package com.example.test

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {


    @Insert
    suspend fun insert(note: NoteModel)

    @Query("SELECT * FROM notes")
     fun getNotes(): Flow<List<NoteModel>>


}