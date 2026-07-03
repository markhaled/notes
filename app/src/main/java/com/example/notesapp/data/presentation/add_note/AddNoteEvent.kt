package com.example.notesapp.data.presentation.add_note

import androidx.compose.ui.focus.FocusState

sealed class AddNoteEvent {
    data class EnteredTitle(val value : String): AddNoteEvent()
    data class EnteredContent(val value : String): AddNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddNoteEvent()
    data class ChangeColor(val color: Int): AddNoteEvent()
    object SaveNote: AddNoteEvent()
}