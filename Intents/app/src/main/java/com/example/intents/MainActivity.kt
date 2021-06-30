package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val intent = Intent().apply{
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"Hello World!")
            type="text/plain"

        }

        try {
            startActivity(intent)
        }catch(e:ClassNotFoundException){
            Toast.makeText(this, "App not found", Toast.LENGTH_SHORT).show()
        }
        }
}