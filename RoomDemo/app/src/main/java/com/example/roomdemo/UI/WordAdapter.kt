package com.example.roomdemo.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.R
import com.example.roomdemo.Room.Word

class WordAdapter(private val mItemClickListener : itemClickListener) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var oldlist = emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent,mItemClickListener)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(oldlist[position])
    }

    override fun getItemCount(): Int  = oldlist.size

    //use a func implementation

     class WordViewHolder(private val view : View , private val onItemClickListener: WordAdapter.itemClickListener ) : RecyclerView.ViewHolder(view){
        private val textView : TextView
         init{
             textView = view.findViewById<TextView>(R.id.text)

         }
         fun bind(item : Word){
             textView.setText(item.word)
             view.setOnClickListener{
                 onItemClickListener.onItemClick(item)
             }
         }

        companion object{
            fun create(parent : ViewGroup,itemClickListener: WordAdapter.itemClickListener) : WordViewHolder{
               val view  = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_layout,parent,false)
                return WordViewHolder(view,itemClickListener)
            }
        }
    }

        fun submitList(newList : List<Word>){
            val diff = WordDiffUtil(oldList = oldlist ,newList)
            oldlist = newList
            val calc = DiffUtil.calculateDiff(diff)
            calc.dispatchUpdatesTo(this)
        }

    interface itemClickListener{
        fun onItemClick(word:Word)
    }
}