package com.example.cn333as5.screens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource


import com.example.cn333as5.domain.model.NoteModel
import com.example.cn333as5.domain.model.TagModel
import com.example.cn333as5.ui.components.Note
import com.example.cn333as5.viewmodel.MainViewModel

@ExperimentalMaterialApi
@Composable
fun NotesScreen(viewModel: MainViewModel) {
    val notes by viewModel.notesNotInTrash.observeAsState(listOf())
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val tags by viewModel.tags.observeAsState(listOf())

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Color.DarkGray,
                title = {
                    Text(
                        text = "Contact Phone",
                        color = MaterialTheme.colors.onPrimary
                    )
                },
            )
        },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = Color.Black,
                onClick = { viewModel.onCreateNewNoteClick() },
                contentColor = MaterialTheme.colors.background,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Note Button"
                    )
                }
            )
        }
    ) {
        if (notes.isNotEmpty()) {
            NotesList(
                notes = notes,
                onNoteClick = { viewModel.onNoteClick(it) },
                tags = tags
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun NotesList(
    notes: List<NoteModel>,
    onNoteClick: (NoteModel) -> Unit,
    tags : List<TagModel>
) {
    LazyColumn {
        items(count = notes.size) { noteIndex ->
            val note = notes[noteIndex]
            val tag = tags[noteIndex]
            Note(
                note = note,
                onNoteClick = onNoteClick,
                tag = tag,
            )
        }
    }
}

