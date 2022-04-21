package com.example.roomex.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomex.REPOSITORY
import com.example.roomex.db.NoteDatabase
import com.example.roomex.db.repository.NoteRealization
import com.example.roomex.model.NoteModel

class StartViewModel(application: Application):AndroidViewModel(application) {
    var context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)

    }

    fun getAllNotes ():LiveData<List<NoteModel>>{
        return REPOSITORY.AllNodes
    }
}