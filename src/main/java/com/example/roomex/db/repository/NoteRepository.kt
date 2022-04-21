package com.example.roomex.db.repository

import androidx.lifecycle.LiveData
import com.example.roomex.model.NoteModel

interface NoteRepository {
    val AllNodes:LiveData<List<NoteModel>>

    suspend fun insertNode (nodeModel: NoteModel, onSuccess: () -> Unit)

    suspend fun deleteNode (nodeModel: NoteModel, onSuccess: () -> Unit)
}