package com.example.threaddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.threaddemos.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var stopThread: Boolean=false
    lateinit private var handler : Handler
    lateinit private var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.startButton.setOnClickListener {
            start()
        }

        binding.stopButton.setOnClickListener {
            stopThread=true
        }
    }

    private fun start() {
        val thread = object : Thread() {
            override fun run() {
                for (i in 0..10) {
                    Thread.sleep(1000)
                    if(stopThread)
                        return
                    Log.e(TAG, i.toString())
                    if (i == 5) {
                        handler = Handler(Looper.getMainLooper())
                        handler.post(
                                object:Runnable{
                                    override fun run() {
                                        binding.startButton.setText("50% ")
                                    }

                                }
                        )
                    }
                }
            }
        }.start()
    }

}




