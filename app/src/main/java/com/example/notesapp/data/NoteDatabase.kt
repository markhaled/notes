package com.example.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDatabaseDao
companion object {
    const val DATABASE_NAME = "notes_db"
 }
}