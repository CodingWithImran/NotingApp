package com.example.noteapp.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.AddActivity
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.database.DatabaseBuilder
import com.example.noteapp.databinding.ItemsNoteBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class NoteAdapters(var context: Context, var list : ArrayList<NoteTable>, var deleteNote : (Int) -> Unit) :
    RecyclerView.Adapter<NoteAdapters.viewHolder>() {


    inner class viewHolder(var binding : ItemsNoteBinding) : RecyclerView.ViewHolder(binding.root) {
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var binding = ItemsNoteBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewHolder(binding)
    }
    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, @SuppressLint("RecyclerView") position: Int) {
        var modal  = list[position]
        holder.binding.noteText.text = modal.data
        holder.binding.itemcard.setCardBackgroundColor(Color.parseColor(modal.color))
        holder.itemView.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                deleteNote(position)
                return false
            }
        })
        holder.itemView.setOnClickListener {
            // Create an Intent to start the AddActivity
            val intent = Intent(holder.itemView.context, AddActivity::class.java)
            // Add extra data to the Intent (assuming "list" is a List of some Parcelable or Serializable objects)
            intent.putExtra("note", list.get(position))
            // Start the activity using the created intent
            holder.itemView.context.startActivity(intent)
        }

    }
}