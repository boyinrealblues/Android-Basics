package com.example.roomdemo.Data

import androidx.annotation.WorkerThread
import com.example.roomdemo.Room.Word
import com.example.roomdemo.Room.WordDao
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao){

    val wordList : Flow<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word : Word){
        wordDao.insert(word)
    }

    @WorkerThread
    suspend fun delete(){
        wordDao.deleteEverything()
    }

    @WorkerThread
    suspend fun deleteEach(word:Word){
        wordDao.deleteThis(word)
    }
}