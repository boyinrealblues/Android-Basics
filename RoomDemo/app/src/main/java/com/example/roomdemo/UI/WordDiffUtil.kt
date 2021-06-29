package com.example.roomdemo.UI

import androidx.recyclerview.widget.DiffUtil
import com.example.roomdemo.Room.Word

class WordDiffUtil(private val oldList : List<Word>, private val newList : List<Word> ) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}