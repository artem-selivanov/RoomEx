package com.example.roomex.db.repository

import androidx.lifecycle.LiveData
import com.example.roomex.db.dao.dao
import com.example.roomex.model.NoteModel

class NoteRealization(private val noteDao:dao):NoteRepository {
    override val AllNodes: LiveData<List<NoteModel>>
        get() = noteDao.gelallnodes()

    override suspend fun insertNode(nodeModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insertNode(nodeModel)
        onSuccess()
    }

    override suspend fun deleteNode(nodeModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.deleteNode(nodeModel)
        onSuccess()
    }
}