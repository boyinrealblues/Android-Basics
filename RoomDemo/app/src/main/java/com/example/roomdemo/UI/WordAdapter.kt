package com.example.roomdemo.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.R
import com.example.roomdemo.Room.Word

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var oldlist = emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(oldlist[position].word)
    }

    override fun getItemCount(): Int  = oldlist.size

     class WordViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        private val textView : TextView
         init{
             textView = view.findViewById<TextView>(R.id.text)
        }
         fun bind(item : String){
             textView.setText(item)
         }


        companion object{
            fun create(parent : ViewGroup) : WordViewHolder{
               val view  = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_layout,parent,false)
                return WordViewHolder(view)
            }
        }
    }

        fun submitList(newList : List<Word>){
            val diff = WordDiffUtil(oldList = oldlist ,newList)
            oldlist = newList
            val calc = DiffUtil.calculateDiff(diff)
            calc.dispatchUpdatesTo(this)
        }
}