package com.example.fragmentandfragmentfactory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BTSAdapter(private val data : ArrayList<Members>,private val interaction: BTSViewHolder.Interaction) : RecyclerView.Adapter<BTSViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BTSViewHolder  {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_view , parent , false)
            return BTSViewHolder(view,interaction)
    }

    override fun onBindViewHolder(holder: BTSViewHolder, position: Int) {
             holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}
class BTSViewHolder(itemView : View, private val interaction : Interaction?) : RecyclerView.ViewHolder(itemView) {

    fun bind(itemData : Members) = with(itemView){
             val imageView = findViewById<ImageView>(R.id.member_image)
                        Glide.with(this).load(itemData.image).into(imageView)

        val nameView = findViewById<TextView>(R.id.member_name)
                    nameView.setText(itemData.name)

            interaction?.onItemClick(this,adapterPosition)
    }

    interface Interaction{
        fun onItemClick(view : View  , position: Int)
    }

}
