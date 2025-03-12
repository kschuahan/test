package com.example.test

import androidx.room.Database
import androidx.room.DeleteTable
import androidx.room.RoomDatabase

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
abstract class NoteRoomDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}