package com.example.roomex.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomex.model.NoteModel

@Dao
interface dao {

    @Insert(onConflict=OnConflictStrategy.IGNORE)
    suspend fun insertNode(noteModel:NoteModel)

    @Delete
    suspend fun deleteNode(noteModel:NoteModel)

    @Query("Select * FROM note_table")
    fun gelallnodes():LiveData<List<NoteModel>>
}