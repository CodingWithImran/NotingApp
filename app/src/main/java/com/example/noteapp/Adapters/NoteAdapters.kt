package com.example.noteapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.Modals.NoteTable
import com.example.noteapp.database.DatabaseBuilder
import com.example.noteapp.databinding.ItemsNoteBinding


class NoteAdapters(var context: Context, var list : ArrayList<NoteTable>) :
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

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var modal  = list[position]
        holder.binding.noteText.text = modal.data
        holder.itemView.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                DatabaseBuilder.getDatabase(context).getNoteDao().delete(modal)
                return true
            }
        })

    }
}