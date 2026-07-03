package com.example.notesapp.di

import android.app.Application
import androidx.room.Room
import com.example.notesapp.data.NoteDatabase
import com.example.notesapp.data.NoteDatabaseDao
import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.domain.use_case.AddNote
import com.example.notesapp.domain.use_case.DeleteNote
import com.example.notesapp.domain.use_case.GetNote
import com.example.notesapp.domain.use_case.GetNotes
import com.example.notesapp.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(db: NoteDatabase): NoteDatabaseDao {
        return db.noteDao()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dao: NoteDatabaseDao): NoteRepository {
        return NoteRepository(dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}
