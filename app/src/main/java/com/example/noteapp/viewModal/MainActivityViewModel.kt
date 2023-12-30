package com.example.noteapp.viewModal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.Modals.Repo

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
//    Below line used in observer for show live data
//    lateinit var noteList : LiveData<List<NoteTable>>

    lateinit var noteList : List<NoteTable>
    lateinit var repo : Repo
    init {
        repo = Repo(application)
        noteList = repo.readNote()
    }
    fun delete(note : NoteTable){
        repo.delete(note)
    }
    fun insert(note: NoteTable){
        repo.insert(note)
    }

}