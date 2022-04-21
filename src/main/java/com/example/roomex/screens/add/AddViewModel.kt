package com.example.roomex.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomex.REPOSITORY
import com.example.roomex.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel:ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO){ REPOSITORY.insertNode(noteModel)
        {onSuccess()}
        }
}