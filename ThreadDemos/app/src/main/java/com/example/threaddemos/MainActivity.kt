package com.example.threaddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit var buttonStart :Button
    lateinit var buttonStop :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         buttonStart = findViewById<Button>(R.id.start_button)

         buttonStop = findViewById<Button>(R.id.stop_button)


        buttonStart.setOnClickListener {

            startThread()
        }
    }

    fun startThread(){
           for(i in 0..10) {
               Log.e(TAG, "startThread: ${i}")
               Thread.sleep(1000)
           }
        }
    }
