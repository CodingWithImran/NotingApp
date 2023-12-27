package com.example.noteapp.Modals

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName =  "note_table")
data class NoteTable(
    @ColumnInfo(name = "data")
    var data: String = "", // Add default value and setter
    @ColumnInfo(name = "Color_Code")
    var color: String = "" // Add default value and setter
) {
    @PrimaryKey(autoGenerate = true)
    var key: Int = 0 // Add setter
}

