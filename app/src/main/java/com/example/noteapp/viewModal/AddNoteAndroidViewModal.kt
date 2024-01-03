package com.example.noteapp.viewModal

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.Modals.Repo

class AddNoteAndroidViewModal(var application : Application) : AndroidViewModel(application) {
    lateinit var repo : Repo
    init {
        repo = Repo(application)
    }
    fun insert(noteList : NoteTable, onSuccess : ()->Unit){
        repo.insert(noteList)
    }
}