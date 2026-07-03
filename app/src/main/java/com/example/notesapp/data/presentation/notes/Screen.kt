package com.example.notesapp.data.presentation.notes



sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddNoteScreen: Screen("add_note_screen")
}