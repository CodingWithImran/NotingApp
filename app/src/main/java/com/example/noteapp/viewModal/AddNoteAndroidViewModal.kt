package com.example.noteapp.viewModal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.Modals.Repo

class AddNoteAndroidViewModal(application: Application) : AndroidViewModel(application) {
//    Below line used in observer for show live data
//    lateinit var noteList : LiveData<List<NoteTable>>

    lateinit var noteList : List<NoteTable>
    lateinit var repo : Repo
    init {
        repo = Repo(application)
        noteList = repo.readNote()
    }

    fun insert(note: NoteTable, onSuccess: () -> Unit){
        repo.insert(note)
        onSuccess()
    }
    fun update(note: NoteTable, onSuccess: () -> Unit){
        repo.update(note)
        onSuccess()
    }
}