package com.example.roomdemo.UI

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdemo.Data.WordRepository
import com.example.roomdemo.Room.WordDao
import java.lang.IllegalArgumentException

private const val TAG = "WordViewModelFactory"
class WordViewModelFactory(private val wordDao: WordDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(WordViewModel::class.java)) return WordViewModel(wordDao) as T

        
//        when(modelClass){
//            WordViewModel::class.java ->{
//                return WordViewModel(repository) as T
//            }
//        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}