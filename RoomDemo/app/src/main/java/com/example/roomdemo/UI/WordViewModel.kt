package com.example.roomdemo.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdemo.Data.WordRepository
import com.example.roomdemo.Room.Word
import kotlinx.coroutines.launch

class WordViewModel(private val repository : WordRepository) : ViewModel() {

    val allWords : LiveData<List<Word>> = repository.wordList.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

    fun delete() = viewModelScope.launch{
        repository.delete()
    }
}