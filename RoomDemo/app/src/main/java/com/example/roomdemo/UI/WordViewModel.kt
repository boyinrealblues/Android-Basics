package com.example.roomdemo.UI

import androidx.lifecycle.*
import com.example.roomdemo.Data.WordRepository
import com.example.roomdemo.Room.Word
import com.example.roomdemo.Room.WordDao
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WordViewModel(private val wordDao: WordDao) : ViewModel() {

    val allWords : LiveData<List<Word>> = wordDao.getAllWords().asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        wordDao.insert(word)
    }

    fun delete() = viewModelScope.launch{
        wordDao.deleteEverything()
    }

    fun deleteThis(word: Word) = viewModelScope.launch{
        wordDao.deleteThis(word)
    }
}