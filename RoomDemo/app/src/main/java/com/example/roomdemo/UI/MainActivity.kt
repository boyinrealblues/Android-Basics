package com.example.roomdemo.UI

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.R
import com.example.roomdemo.Room.Word
import com.example.roomdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model = ViewModelProvider(this , WordViewModelFactory((application as WordApplication).repository)).get(WordViewModel::class.java)
        val mAdapter = WordAdapter()

        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        model.allWords.observe(this , {
            mAdapter.submitList(it)
        })

        val content = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                if(it.resultCode == Activity.RESULT_OK){
                    val word = it.data?.getStringExtra(NewWordActivity.EXTRA_METADATA)
                    model.insert(Word(word!!))
                }else{
                    Toast.makeText(this, "Empty word cant be added", Toast.LENGTH_SHORT).show()
                }
        }

        binding.fab.setOnClickListener{
            val intent = Intent(this , NewWordActivity::class.java)
            content.launch(intent)
        }

    }
}