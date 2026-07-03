package com.example.notesapp.data.presentation.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.domain.util.NoteOrder
import com.example.notesapp.domain.util.OrderType

@Composable
fun Order(modifier: Modifier = Modifier, noteOrder: NoteOrder= NoteOrder.Date(OrderType.Descending),
          onOrderChange: (NoteOrder) -> Unit){
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            RadioButton(text = "Title", selected = noteOrder is NoteOrder.Title, onClick = {
                onOrderChange(NoteOrder.Title(noteOrder.orderType))
            })
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(text = "Date", selected = noteOrder is NoteOrder.Date, onClick = {
                onOrderChange(NoteOrder.Date(noteOrder.orderType))
            })
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(text = "Color", selected = noteOrder is NoteOrder.Color, onClick = {
                onOrderChange(NoteOrder.Color(noteOrder.orderType))
            })

        }
        Spacer(modifier = Modifier.width(16.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            RadioButton(text = "Ascending", selected = noteOrder.orderType is OrderType.Ascending, onClick = {
                onOrderChange(noteOrder.copy(OrderType.Ascending))

            })
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(text = "Descending", selected = noteOrder.orderType is OrderType.Descending, onClick = {
                onOrderChange(noteOrder.copy(OrderType.Descending))

            })

        }
    }
}