package com.example.basicactivitytests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.basicactivitytests.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit private var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_second)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }

    }
}