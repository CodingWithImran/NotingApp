package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
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
    private  var adapter : NoteAdapters? = null
    lateinit var mainActivityViewModel: MainActivityViewModel
    var list = ArrayList<NoteTable>()
    val binding by lazy{
       ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

//        Below commented line used for add liveDATA
//        list.addAll(mainActivityViewModel.noteList.value!!)

//        list.clear()
//        list.addAll(mainActivityViewModel.noteList)
//        binding.recNote.layoutManager = LinearLayoutManager(this)
//        adapter = NoteAdapters(this, list){
//            deleteNote(it)
//        }
//        binding.recNote.adapter = adapter
//        adapter?.notifyDataSetChanged()
//            // BELOW CODE ONLY USED FOR SHOW LIVE DATA IN OBSERVER WHICH WORK IN VIEWMODAL
//        var observer = Observer<List<NoteTable>>{
//            list.clear()
//            list.addAll(it)
//            if (adapter==null){
//
//                binding.recNote.layoutManager = LinearLayoutManager(this)
//                adapter = NoteAdapters(this, list){
//                    deleteNote(it)
//                }
//                binding.recNote.adapter = adapter
//
//            }else{
//                adapter?.notifyDataSetChanged()
//            }
//        }
//        mainActivityViewModel.noteList.observe(this, observer)
//
////             ✔✔✔✔✔✔✔ below two line code only was used for checking room data in recyclerView. Now it has been changed in Observer format in viewModal
//        val noteDao = DatabaseBuilder.getDatabase(this)?.getNoteDao()
//        list.addAll(mainActivityViewModel.noteList.value!!)
//        binding.addBtn.setOnClickListener {
//            startActivity(Intent(this, AddActivity::class.java))
//        }

    }
    fun deleteNote(position : Int){
        mainActivityViewModel.delete(list.get(position))
        list.removeAt(position)
        adapter!!.notifyItemRemoved(position)
    }
}