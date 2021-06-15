package com.example.glidecodelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.glidecodelab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        attach()
    }

    private fun attach() {
        Glide.with(this).load("https://i.pinimg.com/originals/c6/b5/d0/c6b5d070a10f816be2e6199f40d8e77a.png").into(binding.image)
    }
}