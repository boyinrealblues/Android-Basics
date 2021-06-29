package com.example.roomdemo.UI

import android.app.Application
import com.example.roomdemo.Data.WordRepository
import com.example.roomdemo.Room.WordRoomDatabase

class WordApplication : Application() {

    val database by lazy{
        WordRoomDatabase.getDatabase(this)
    }
    val repository by lazy{
        WordRepository(database.getDao())
    }
}