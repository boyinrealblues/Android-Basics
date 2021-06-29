package com.example.roomdemo.Room

import android.content.Context
import androidx.annotation.RestrictTo
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Word::class),version = 1,exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun getDao():WordDao

    class WordDataBaseCallBack(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let{database->
                scope.launch{
                    //Deletes everything
                    database.getDao().deleteEverything()

                    //Insert
                    database.getDao().insert(Word("Kitanai"))
                    database.getDao().insert(Word("Amai"))


                }
            }
        }
    }

    companion object{

        @Volatile
        var INSTANCE : WordRoomDatabase? = null

        fun getDatabase(context: Context , scope : CoroutineScope):WordRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext , WordRoomDatabase::class.java , "word_database").addCallback(WordDataBaseCallBack(scope)).build()

                INSTANCE = instance
                instance
            }
        }
     }

}