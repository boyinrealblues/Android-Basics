package com.example.roomdemo.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao{
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): Flow<List<Word>>

    @Query("DELETE FROM word_table")
    suspend fun deleteEverything()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)
}