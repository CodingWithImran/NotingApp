package com.example.noteapp.Modals

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.noteapp.DAO.NoteDao
import com.example.noteapp.database.DatabaseBuilder

class Repo(var context: Context) {
    var daoObject:NoteDao = DatabaseBuilder.getDatabase(context).getNoteDao()

//    Below line used for observer to show live data
//    fun readNote(): LiveData<List<NoteTable>>{
//        return daoObject.readNote()
//    }

    fun readNote(): List<NoteTable>{
        return daoObject.readNote()
    }

    fun insert(note : NoteTable) {
        daoObject.insert(note)
    }
    fun update(note : NoteTable){
        daoObject.update(note)
    }
    fun delete(note : NoteTable){
        daoObject.delete(note)
    }
}