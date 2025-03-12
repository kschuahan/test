package com.example.test

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun getNoteDatabase(@ApplicationContext applicationContext: Context): NoteRoomDatabase {
        return Room.databaseBuilder(
            applicationContext,
            NoteRoomDatabase::class.java,
            "note_database"
        ).build()
    }
}