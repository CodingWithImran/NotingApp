package com.example.noteapp.viewModal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.Modals.Repo

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var noteList : List<NoteTable>
    init {
        var repo : Repo = Repo(application)
        noteList = repo.readNote()
    }


}