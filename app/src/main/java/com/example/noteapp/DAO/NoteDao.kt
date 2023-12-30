package com.example.noteapp.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.Modals.NoteTable

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note:NoteTable)

    @Update
    fun update(note : NoteTable)

//    Below two line used in observer for show liveData
//    @Query ("Select * From 'note_table'")
//    fun readNote() : LiveData<List <NoteTable>>
    @Query ("Select * From 'note_table'")
    fun readNote() : List <NoteTable>

    @Delete
    fun delete(note : NoteTable)
}