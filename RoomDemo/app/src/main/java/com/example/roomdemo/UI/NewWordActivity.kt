package com.example.roomdemo.UI

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.roomdemo.R
import com.example.roomdemo.databinding.ActivityMainBinding
import com.example.roomdemo.databinding.ActivityNewWordBinding

class NewWordActivity : AppCompatActivity(){
    lateinit private var binding : ActivityNewWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_word)
        binding.button.setOnClickListener {
            val text =binding.editTextTextPersonName.text.toString()
            val intent = Intent()
            if(text.equals("")){
                setResult(Activity.RESULT_CANCELED,intent)
            }else{
                intent.putExtra(EXTRA_METADATA,text)
                setResult(Activity.RESULT_OK,intent)
            }
            finish()
        }
    }

    companion object{
        const val EXTRA_METADATA = " com.example.roomdemo.UI"
    }
}