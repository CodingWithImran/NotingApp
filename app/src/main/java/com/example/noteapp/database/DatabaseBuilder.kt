package com.example.noteapp.database

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


object DatabaseBuilder {
    private var INSTANCE: NoteDatabase? = null

    @OptIn(InternalCoroutinesApi::class)
    fun getDatabase(context: Context): NoteDatabase {
        if (INSTANCE == null) {
            synchronized(NoteDatabase::class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note_database.db"
                    ).allowMainThreadQueries().build()
                }
            }
        }
        return INSTANCE!!
    }
}