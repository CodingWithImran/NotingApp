package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.Adapters.NoteAdapters
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.databinding.ActivityAddBinding
import com.example.noteapp.viewModal.AddNoteAndroidViewModal
import kotlin.random.Random

class AddActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityAddBinding.inflate(layoutInflater)
    }
    var noteTable : NoteTable  = NoteTable()
    private lateinit var addViewModal : AddNoteAndroidViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        addViewModal = ViewModelProvider(this).get(AddNoteAndroidViewModal::class.java)
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        if(intent.hasExtra("note")){
            var noteTable = intent.getSerializableExtra("note") as NoteTable
            binding.noteData.setText(noteTable.data)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save -> {
                if(intent.hasExtra("note")){
                    var text = binding.noteData.text.toString()
                    noteTable.data  = text
                    addViewModal.update(noteTable){
                        finish()
                    }
                }else{
                    noteTable = NoteTable(
                        data = binding.noteData.text.toString(),
                        color = generateRandomColorCode())
                    addViewModal.insert(noteTable){
                        finish()
                    }
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun generateRandomColorCode(): String {
        val random = Random.Default
        val hexChars = "0123456789ABCDEF"
        val colorCode = StringBuilder("#")

        for (i in 1..6) {
            colorCode.append(hexChars[random.nextInt(16)])
        }

        return colorCode.toString()
    }
}