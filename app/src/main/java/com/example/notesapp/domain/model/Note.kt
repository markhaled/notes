package com.example.notesapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesapp.ui.theme.Blue
import com.example.notesapp.ui.theme.Green
import com.example.notesapp.ui.theme.Orange
import com.example.notesapp.ui.theme.Red
import com.example.notesapp.ui.theme.Yellow


@Entity(tableName="notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "note_title")
    val title : String,
    @ColumnInfo(name = "note_content")
    val content: String,
    @ColumnInfo(name = "time_stamp")
    val timestamp: Long,
    @ColumnInfo(name = "color")
    val color: Int
){
    companion object{
        val noteColors = listOf(Red, Yellow, Green, Blue, Orange)
    }
}
class InvalidNoteException(message: String): Exception(message)
