package com.example.roomdemo.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(Word::class),version = 1,exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun getDao():WordDao

    companion object{

        @Volatile
        var INSTANCE : WordRoomDatabase? = null

        fun getDatabase(context: Context):WordRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext , WordRoomDatabase::class.java , "word_database").build()

                INSTANCE = instance
                instance
            }
        }
     }

}