package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.Adapters.NoteAdapters
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.database.DatabaseBuilder
import com.example.noteapp.database.NoteDatabase
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.databinding.ItemsNoteBinding
import com.example.noteapp.viewModal.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : NoteAdapters
    lateinit var mainActivityViewModel: MainActivityViewModel
    var list = ArrayList<NoteTable>()
    val binding by lazy{
       ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val noteDao = DatabaseBuilder.getDatabase(this)?.getNoteDao()
        list.addAll(mainActivityViewModel.noteList)
        adapter = NoteAdapters(this, list)
        binding.recNote.adapter = adapter
        binding.recNote.layoutManager = LinearLayoutManager(this)

//        if (noteDao != null) {
//            noteDao.insert(NoteTable("233334", "jfasjdfslkd"))
//        } else {
//            Toast.makeText(this@MainActivity, "null", Toast.LENGTH_SHORT).show()
//        }

    }
}