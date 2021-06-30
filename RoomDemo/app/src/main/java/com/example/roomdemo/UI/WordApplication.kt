package com.example.roomdemo.UI

import android.app.Application
import android.app.job.JobScheduler
import com.example.roomdemo.Data.WordRepository
import com.example.roomdemo.Room.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

//Make this singleton
class WordApplication : Application() {

    val scope = CoroutineScope(SupervisorJob())

    val database by lazy{
        WordRoomDatabase.getDatabase(this,scope)
    }
    val repository by lazy{
        WordRepository(database.getDao())
    }
}