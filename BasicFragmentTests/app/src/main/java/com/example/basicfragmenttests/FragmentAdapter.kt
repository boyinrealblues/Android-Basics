package com.example.basicfragmenttests

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.example.basicfragmenttests.databinding.ActivityMainBinding.inflate

class FragmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit private var dataSource : RemoteAlbumDataSource

    init{
        //initialize dataSource
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.inflate(this ,R.layout.fragment_list , parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    class AlbumViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(item : Album) = with(itemView){

        }
    }
}