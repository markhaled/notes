package com.example.notesapp.data.repository

import com.example.notesapp.data.NoteDatabaseDao
import com.example.notesapp.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: Note) = noteDatabaseDao.insert(note)
    suspend fun deleteNote(note: Note) = noteDatabaseDao.delete(note)
    fun getNotes(): Flow<List<Note>> = noteDatabaseDao.getNotes()
    suspend fun getNoteById(id: Int): Note? = noteDatabaseDao.getNoteById(id)

}