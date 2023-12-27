package com.example.noteapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.DAO.NoteDao
import com.example.noteapp.Modals.NoteTable

@Database (entities = arrayOf(NoteTable::class), exportSchema = false, version = 1)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun getNoteDao() : NoteDao
}