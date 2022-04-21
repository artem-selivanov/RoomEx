package com.example.roomex.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomex.db.dao.dao
import com.example.roomex.model.NoteModel
import kotlin.math.log

@Database(entities = [NoteModel::class], version = 4)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): dao

    companion object {
        private var database: NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            return if (database == null) {
              //  Log.i("test", "Place 1")
                database = Room.databaseBuilder(context, NoteDatabase::class.java, "db").build()
             //   Log.i("test", "Place 2")
                database as NoteDatabase

            } else {
               // Log.i("test", "Place 3")
                database as NoteDatabase
            }
        }


    }
}