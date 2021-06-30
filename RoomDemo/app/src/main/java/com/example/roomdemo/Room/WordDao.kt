package com.example.roomdemo.Room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao{
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): Flow<List<Word>>

    @Query("DELETE FROM word_table")
    suspend fun deleteEverything()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Delete
    suspend fun deleteThis(word: Word)
}