package com.example.noteapp

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.databinding.ActivityAddBinding
import com.example.noteapp.viewModal.AddNoteAndroidViewModal
import kotlin.random.Random

class AddActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityAddBinding.inflate(layoutInflater)
    }
    lateinit var addViewModal : AddNoteAndroidViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        addViewModal = ViewModelProvider(this).get(AddNoteAndroidViewModal::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.left_menu, menu)
        menuInflater.inflate(R.menu.right_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save -> {
                var noteTable = NoteTable(data = binding.noteData.text.toString(), color = generateRandomColorCode())
                addViewModal.insert(noteTable){
                    finish()
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