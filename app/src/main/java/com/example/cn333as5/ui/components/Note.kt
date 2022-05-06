package com.example.cn333as5.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cn333as5.domain.model.NoteModel
import com.example.cn333as5.domain.model.TagModel
import com.example.cn333as5.util.fromHex

@ExperimentalMaterialApi
@Composable
fun Note(
    modifier: Modifier = Modifier,
    note: NoteModel,
    onNoteClick: (NoteModel) -> Unit = {},
    tag: TagModel
) {

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),

    ) {
        ListItem(
            secondaryText  = { Text(text = note.title, maxLines = 1) },
            text = {
                Text(text = note.content, maxLines = 1)
            },
            icon = {
                NoteColor(
                    color = Color.fromHex(note.color.hex),
                    size = 40.dp,
                    border = 0.dp,
                )
            },
            modifier = Modifier.clickable {
                onNoteClick.invoke(note)
            },
            trailing = {Text(text = tag.nameTag, maxLines = 1)}

        )
    }
}
