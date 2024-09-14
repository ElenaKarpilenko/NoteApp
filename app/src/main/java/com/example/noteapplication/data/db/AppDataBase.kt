package com.example.noteapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapplication.data.db.dao.NoteDao
import com.example.noteapplication.data.model.NoteModel


@Database(entities = [NoteModel::class], version = 3)
abstract class AppDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}