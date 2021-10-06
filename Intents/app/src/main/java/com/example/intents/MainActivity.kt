package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.intentscla.R
import com.example.intentscla.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding
    private var text:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
       text = binding.editTextTextPersonName.text.toString()

            val intent = makeIntent(text.toString())

            try {
                Log.e("text",text.toString())
                startActivity(intent)
            } catch (e: ClassNotFoundException) {
                Toast.makeText(this, "App not found", Toast.LENGTH_SHORT).show()

            }
        }
        }

    private fun makeIntent(text: String): Intent? = Intent().apply{
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,text)
            type="text/plain"

        }
    }
