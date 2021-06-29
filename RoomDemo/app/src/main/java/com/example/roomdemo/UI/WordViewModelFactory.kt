package com.example.roomdemo.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdemo.Data.WordRepository
import java.lang.IllegalArgumentException

class WordViewModelFactory(private val repository : WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            return WordViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}